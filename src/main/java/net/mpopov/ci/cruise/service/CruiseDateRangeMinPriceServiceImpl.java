package net.mpopov.ci.cruise.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.mpopov.ci.common.CurrencyUtil;
import net.mpopov.ci.cruise.dao.CruiseDateRangeMinPriceDAO;
import net.mpopov.ci.cruise.model.CruiseDateRange;
import net.mpopov.ci.cruise.model.CruiseDateRangeMinPrice;
import net.mpopov.ci.cruise.model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cruiseDateRangeMinPriceService")
public class CruiseDateRangeMinPriceServiceImpl implements CruiseDateRangeMinPriceService{

	@Autowired
	private CruiseDateRangeMinPriceDAO cruiseDateRangeMinPriceDAO;
	
	@Transactional
	public void updateRates(Map<Long, Double> rates, List<Long> excludedCompanyIds) {
		
		Set<Long> removedIds = new HashSet<Long>();
		
		List<CruiseDateRangeMinPrice> cruiseDateRangeMinPrices = cruiseDateRangeMinPriceDAO
				.listCbrMinPrices(excludedCompanyIds);
		
		Long prevId = null;
		Map<Long, Double> currMinPrices= null;
		for (CruiseDateRangeMinPrice cruiseDateRangeMinPrice : cruiseDateRangeMinPrices)
		{
			if (!rates.containsKey(cruiseDateRangeMinPrice.getCurrency().getCurrencyId()))
			{
				removedIds.add(cruiseDateRangeMinPrice.getCurrency().getCurrencyId());
			}
				
			if (!cruiseDateRangeMinPrice.getCruiseDateRange()
					.getCruiseDateRangeId().equals(prevId))
			{
				addNewRateForMinPrice(prevId, currMinPrices);
				if (!rates.containsKey(cruiseDateRangeMinPrice.getCurrency()
						.getCurrencyId()))
				{
					continue;
				}

				currMinPrices = CurrencyUtil.getPricesByCurrencies(
						cruiseDateRangeMinPrice.getCurrency().getCurrencyId(),
						cruiseDateRangeMinPrice.getMinPriceValue(), rates);
				
				prevId = cruiseDateRangeMinPrice.getCruiseDateRange()
						.getCruiseDateRangeId();

			}
			
			if (currMinPrices.containsKey(cruiseDateRangeMinPrice.getCurrency().getCurrencyId()))
			{
				cruiseDateRangeMinPrice.setMinPriceValue(currMinPrices
						.get(cruiseDateRangeMinPrice.getCurrency()
								.getCurrencyId()));
				cruiseDateRangeMinPriceDAO.save(cruiseDateRangeMinPrice);
				currMinPrices.remove(cruiseDateRangeMinPrice.getCurrency().getCurrencyId());
			}
		}
		
		addNewRateForMinPrice(prevId, currMinPrices);
		
		for (Long removedId : removedIds)
		{
			cruiseDateRangeMinPriceDAO.remove(removedId);
		}

	}

	private void addNewRateForMinPrice(Long prevId,
			Map<Long, Double> currMinPrices) {
		if (prevId == null || currMinPrices == null)
		{
			return;
		}
		
		for (Entry<Long, Double> rate : currMinPrices.entrySet())
		{
			CruiseDateRangeMinPrice cruiseDateRangeMinPrice = new CruiseDateRangeMinPrice();
			Currency currency = new Currency();
			currency.setCurrencyId(rate.getKey());
			cruiseDateRangeMinPrice.setCurrency(currency);
			CruiseDateRange cruiseDateRange = new CruiseDateRange();
			cruiseDateRange.setCruiseDateRangeId(prevId);
			cruiseDateRangeMinPrice.setCruiseDateRange(cruiseDateRange);
			cruiseDateRangeMinPrice.setMinPriceValue(rate.getValue());
			
			cruiseDateRangeMinPriceDAO.add(cruiseDateRangeMinPrice);
		}
		
	}

}

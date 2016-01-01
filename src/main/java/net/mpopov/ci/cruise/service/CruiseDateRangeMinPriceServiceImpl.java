package net.mpopov.ci.cruise.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.mpopov.ci.common.CurrencyUtil;
import net.mpopov.ci.cruise.dao.CruiseDateRangeMinPriceDAO;
import net.mpopov.ci.cruise.model.CruiseDateRange;
import net.mpopov.ci.cruise.model.CruiseDateRangeMinPrice;
import net.mpopov.ci.cruise.model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cruiseDateRangeMinPriceService")
public class CruiseDateRangeMinPriceServiceImpl
        implements CruiseDateRangeMinPriceService
{

    @Autowired
    private CruiseDateRangeMinPriceDAO cruiseDateRangeMinPriceDAO;

    @Transactional
    public void updateRates(Map<Long, Double> rates,
            List<Long> excludedCompanyIds)
    {

        List<CruiseDateRangeMinPrice> cruiseDateRangeMinPrices = cruiseDateRangeMinPriceDAO
                .listCbrMinPrices(excludedCompanyIds);

        Long prevId = null;
        Map<Long, Double> currMinPrices = null;
        for (CruiseDateRangeMinPrice cruiseDateRangeMinPrice : cruiseDateRangeMinPrices)
        {
            Long currCruiseDateRangeId = cruiseDateRangeMinPrice
                    .getCruiseDateRange().getCruiseDateRangeId();
            if (!currCruiseDateRangeId.equals(prevId))
            {
                removeForDateRange(currCruiseDateRangeId);

                currMinPrices = CurrencyUtil.getPricesByCurrencies(
                        cruiseDateRangeMinPrice.getCurrency().getCurrencyId(),
                        cruiseDateRangeMinPrice.getMinPriceValue(), rates);
                
                addNewRateForMinPrice(currCruiseDateRangeId, currMinPrices);

                prevId = cruiseDateRangeMinPrice.getCruiseDateRange()
                        .getCruiseDateRangeId();
            }
        }
    }

    private void removeForDateRange(Long cruiseDateRangeId)
    {
        cruiseDateRangeMinPriceDAO.removeByDateRange(cruiseDateRangeId);
    }

    private void addNewRateForMinPrice(Long prevId,
            Map<Long, Double> currMinPrices)
    {
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

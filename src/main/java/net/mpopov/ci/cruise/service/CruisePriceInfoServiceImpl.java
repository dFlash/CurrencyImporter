package net.mpopov.ci.cruise.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mpopov.ci.common.CurrencyUtil;
import net.mpopov.ci.cruise.dao.CruisePriceInfoDAO;
import net.mpopov.ci.cruise.model.CruisePriceInfo;

@Service("cruisePriceInfoService")
public class CruisePriceInfoServiceImpl implements CruisePriceInfoService
{

    @Autowired
    private CruisePriceInfoDAO cruisePriceInfoDAO;

    private Map<Long, Double> currencyPrices = null;
    private Map<Long, Double> currencyPricesOne = null;
    private Map<Long, Double> currencyPricesTwo = null;
    private Map<Long, Double> currencyPricesThree = null;
    private Map<Long, Double> currencyPricesFour = null;
    private Map<Long, Double> currencyPricesAddChild = null;
    private Map<Long, Double> currencyPricesAdd2Child = null;
    private Map<Long, Double> currencyPricesPortAdult = null;
    private Map<Long, Double> currencyPricesPortChild = null;

    @Override
    public void updateRates(Map<Long, Double> rates,
            List<Long> excludedCompanyIds)
    {
        List<CruisePriceInfo> cruisePricesInfo = cruisePriceInfoDAO
                .listCbrPrices(excludedCompanyIds);

        Long prevId = null;
        for (CruisePriceInfo cruisePriceInfo : cruisePricesInfo)
        {
            Long currCruiseDateRangeId = cruisePriceInfo
                    .getCruiseDateRange().getCruiseDateRangeId();
            if (!currCruiseDateRangeId.equals(prevId))
            {
                removeForDateRangeAndCabin(currCruiseDateRangeId,
                        cruisePriceInfo.getCabinId());

                currencyPrices = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValue(), rates);
                currencyPricesOne = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueOne() != null
                                ? cruisePriceInfo.getPriceValueOne() : 0.0,
                        rates);
                currencyPricesTwo = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueTwo() != null
                                ? cruisePriceInfo.getPriceValueTwo() : 0.0,
                        rates);
                currencyPricesThree = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueThree() != null
                                ? cruisePriceInfo.getPriceValueThree() : 0.0,
                        rates);
                currencyPricesFour = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueFour() != null
                                ? cruisePriceInfo.getPriceValueFour() : 0.0,
                        rates);
                currencyPricesAddChild = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueAddChild() != null
                                ? cruisePriceInfo.getPriceValueAddChild() : 0.0,
                        rates);
                currencyPricesAdd2Child = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPriceValueAdd2Child() != null
                                ? cruisePriceInfo.getPriceValueAdd2Child()
                                : 0.0,
                        rates);
                currencyPricesPortAdult = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPricePortAdult(), rates);
                currencyPricesPortChild = CurrencyUtil.getPricesByCurrencies(
                        cruisePriceInfo.getCurrency().getCurrencyId(),
                        cruisePriceInfo.getPricePortChild(), rates);

                addNewRateForPriceInfo(cruisePriceInfo);

                prevId = cruisePriceInfo.getCruiseDateRange()
                        .getCruiseDateRangeId();
            }
        }
        
    }

    private void addNewRateForPriceInfo(CruisePriceInfo cruisePriceInfo)
    {
        for (Entry<Long, Double> entry : currencyPrices.entrySet())
        {
            CruisePriceInfo addCruisePriceInfo = new CruisePriceInfo();
            addCruisePriceInfo.setCabinId(cruisePriceInfo.getCabinId());
            addCruisePriceInfo
                    .setCruiseDateRange(cruisePriceInfo.getCruiseDateRange());
            addCruisePriceInfo
                    .setCruisePriceId(cruisePriceInfo.getCruisePriceId());
            addCruisePriceInfo.setDateTime(cruisePriceInfo.getDateTime());
            addCruisePriceInfo.setCurrency(cruisePriceInfo.getCurrency());

            addCruisePriceInfo.setPriceValue(entry.getValue());
            addCruisePriceInfo
                    .setPriceValueOne(currencyPricesOne.get(entry.getKey()));
            addCruisePriceInfo
                    .setPriceValueTwo(currencyPricesTwo.get(entry.getKey()));
            addCruisePriceInfo.setPriceValueThree(
                    currencyPricesThree.get(entry.getKey()));
            addCruisePriceInfo
                    .setPriceValueFour(currencyPricesFour.get(entry.getKey()));
            addCruisePriceInfo.setPriceValueAddChild(
                    currencyPricesAddChild.get(entry.getKey()));
            addCruisePriceInfo.setPriceValueAdd2Child(
                    currencyPricesAdd2Child.get(entry.getKey()));
            addCruisePriceInfo.setPricePortAdult(
                    currencyPricesPortAdult.get(entry.getKey()));
            addCruisePriceInfo.setPricePortChild(
                    currencyPricesPortChild.get(entry.getKey()));

            cruisePriceInfoDAO.add(addCruisePriceInfo);
        }
    }

    private void removeForDateRangeAndCabin(Long cruiseDateRangeId, Long cabinId)
    {
        cruisePriceInfoDAO.remove(cruiseDateRangeId, cabinId);
    }

}

package net.mpopov.ci.cruise.importer;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mpopov.ci.common.BaseImporter;
import net.mpopov.ci.common.CurrencyUtil;
import net.mpopov.ci.common.DateTimeUtil;
import net.mpopov.ci.common.MSCIException;
import net.mpopov.ci.configuration.Configuration;
import net.mpopov.ci.cruise.model.Currency;
import net.mpopov.ci.cruise.model.CurrencyExchangeRate;
import net.mpopov.ci.cruise.service.CurrencyExchangeRateService;
import net.mpopov.ci.cruise.service.CurrencyService;
import net.mpopov.ci.xml.model.ModelUtil;
import net.mpopov.ci.xml.model.currency.ObjectFactory;
import net.mpopov.ci.xml.model.currency.ValuteType;
import net.mpopov.ci.xml.model.currency.ValCursType;

public class CurrencyImporter extends BaseImporter
{

    private String directoryPath;

    private String fileName;

    private Map<Long, Double> currencyRates;

    public CurrencyImporter(String directoryPath, String fileName)
    {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        currencyRates = new HashMap<Long, Double>();
    }

    @Override
    protected void importData() throws MSCIException
    {
        List<String> allowableCurrencies = Configuration.getInstance()
                .getCurrenciesList().getCurrency();

        ValCursType valCursType = ModelUtil
                .<ValCursType, ObjectFactory> getRootType(directoryPath,
                        fileName, ObjectFactory.class);
        List<ValuteType> valuteTypes = valCursType.getValute();

        for (ValuteType valute : valuteTypes)
        {
            String charCode = valute.getCharCode();
            if (allowableCurrencies.contains(charCode))
            {
                importCurrencyRate(valute);
            }
        }
    }

    private void importCurrencyRate(ValuteType valute) throws MSCIException
    {
        CurrencyExchangeRateService currencyExchangeRateService = getBean(
                "currencyExchangeRateService");
        CurrencyService currencyService = getBean("currencyService");

        List<Currency> currencies = currencyService.list();
        String charCode = valute.getCharCode();

        long currencyId = getCurrencyId(currencies, charCode);
        try
        {
            double rateValue;

            rateValue = CurrencyUtil.getCurrencyRateValue(valute.getValue());

            rateValue /= valute.getNominal();

            currencyRates.put(currencyId, rateValue);

            CurrencyExchangeRate currencyExchangeRate = getCurrencyExchangeRate(currencyId,
                    rateValue);
            currencyExchangeRateService.add(currencyExchangeRate);
        }
        catch (ParseException e)
        {
            throw new MSCIException("Exchange rate is not valid.", e);
        }
    }

    private CurrencyExchangeRate getCurrencyExchangeRate(long currencyId,
            double rateValue) throws MSCIException
    {
        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
        currencyExchangeRate.setCurrencyId(currencyId);
        currencyExchangeRate.setDateTime(DateTimeUtil.getCurrentDateTime());
        currencyExchangeRate.setForCurrencyId(
                Configuration.getInstance().getForCurrencyId());
        currencyExchangeRate.setRateValue(rateValue);
        currencyExchangeRate
                .setSourceType(Configuration.getInstance().getSourceType());
        return currencyExchangeRate;
    }

    private long getCurrencyId(List<Currency> currencies, String charCode)
            throws MSCIException
    {
        for (Currency currency : currencies)
        {
            if (currency.getCode().equals(charCode))
            {
                return currency.getCurrencyId();
            }
        }
        String msg = String.format("Currency with code %s does not exist",
                charCode);
        throw new MSCIException(msg);
    }

}

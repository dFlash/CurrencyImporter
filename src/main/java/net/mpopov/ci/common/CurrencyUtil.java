package net.mpopov.ci.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CurrencyUtil
{

    private static final char COMMA_SEPARATOR = ',';

    public static double getCurrencyRateValue(String valueString)
            throws ParseException
    {
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(COMMA_SEPARATOR);
        df.setDecimalFormatSymbols(symbols);
        double currencyRateValue = (Double) df.parse(valueString);

        return currencyRateValue;
    }

    /**
     * Retrieving prices for all currencies
     * 
     * @param currency
     *            - base currency (from admin pane)
     * @param price
     *            - price in base currency
     * @param currencyExchangeRates
     *            - exchange rates for cruise
     * @return collection with pairs (key - currency id, value - corresponding
     *         price)
     */
    public static Map<Long, Double> getPricesByCurrencies(Long currencyId,
            Double price, Map<Long, Double> currencyExchangeRates)
    {
        Map<Long, Double> pricesByCurrencies = new HashMap<Long, Double>();
        pricesByCurrencies.put(currencyId, price);
        Double baseCurrencyRate = null;
        for (Entry<Long, Double> rate : currencyExchangeRates.entrySet())
        {
            if (rate.getKey().equals(currencyId))
            {
                baseCurrencyRate = rate.getValue();
                break;
            }
        }

        for (Entry<Long, Double> rate : currencyExchangeRates.entrySet())
        {
            if (!rate.getKey().equals(currencyId))
            {
                Double currPrice = price * baseCurrencyRate / rate.getValue();
                pricesByCurrencies.put(rate.getKey(), currPrice);
            }
        }

        return pricesByCurrencies;
    }

}

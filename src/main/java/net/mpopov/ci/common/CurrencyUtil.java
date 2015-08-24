package net.mpopov.ci.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class CurrencyUtil {
	
	private static final char COMMA_SEPARATOR = ',';
	
	public static double getCurrencyRateValue(String valueString) throws ParseException
	{
		DecimalFormat df = new DecimalFormat();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(COMMA_SEPARATOR);
		df.setDecimalFormatSymbols(symbols);
		double currencyRateValue = (Double) df.parse(valueString);
		
		return currencyRateValue;
	}

}

package net.mpopov.ci.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;

public class DateTimeUtil
{
    private static final String TIME_ZONE_ID = "GMT+2";

    private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH-mm-ss";

    private static GregorianCalendar getCalendar()
    {
        TimeZone timeZone = TimeZone.getTimeZone(TIME_ZONE_ID);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);

        return gregorianCalendar;
    }

    public static Date getCurrentDateTime()
    {
        Calendar calendar = getCalendar();
        return calendar.getTime();
    }

    public static Date addDays(Date date, int amount)
    {
        Date truncatedDate = DateUtils.truncate(date, Calendar.DATE);

        return DateUtils.addDays(truncatedDate, amount);
    }

    public static Date getDate(String date, String datePattern)
            throws ParseException
    {
        DateFormat dateFormat = new java.text.SimpleDateFormat(datePattern);
        Date dateValue = dateFormat.parse(date);
        return dateValue;
    }

    public static String getFormattedDate()
    {
        return getFormattedDate(getCurrentDateTime(), DEFAULT_DATE_TIME_PATTERN);
    }

    public static String getFormattedDate(Date date)
    {
        return getFormattedDate(date, DEFAULT_DATE_TIME_PATTERN);
    }

    public static String getFormattedDate(Date date, String pattern)
    {
        String formattedDate = "";

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(pattern);
        formattedDate = dateTimeFormat.format(date);

        return formattedDate;
    }

}

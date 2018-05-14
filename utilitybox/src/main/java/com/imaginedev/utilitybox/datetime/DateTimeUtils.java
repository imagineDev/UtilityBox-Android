package com.imaginedev.utilitybox.datetime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by batman on 04/03/18.
 */

public final class DateTimeUtils {


    /**
     * @return readable date like ->  August 12, 2014 (default)
     */
    public static String getFormattedDate(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, 0);
    }

    /**
     * @return readable date like ->  Aug 12, 2014 (default with abbreviated month)
     */
    public static String getFormattedDateAbbreviated(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_ABBREV_MONTH);
    }

    /**
     * @return readable date like ->  August 12 (date without year)
     */
    public static String getFormattedDateWithoutYear(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_NO_YEAR);
    }

    /**
     * @return readable date like ->  Aug 12 (date abbreviated without year)
     */
    public static String getFormattedDateAbbreviatedWithoutYear(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_NO_YEAR | DateUtils.FORMAT_ABBREV_MONTH);
    }

    /**
     * @return readable time like ->  8:58 PM (time)
     */
    public static String getFormattedTime(Context ctx, long millis, boolean is24HoursFormat) {
        if (is24HoursFormat)
            return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_24HOUR);
        else
            return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_TIME);
    }


    /**
     * @return readable day of week like ->  Tuesday (weekday)
     */
    public static String getFormattedDayOfWeek(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_WEEKDAY);
    }

    /**
     * @return readable day of week like ->  Tue (weekday)
     */
    public static String getFormattedAbbreviatedDayOfWeek(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_WEEKDAY |
                DateUtils.FORMAT_ABBREV_WEEKDAY);
    }


    /**
     * @return readable date ->  August 2018
     */
    public static String getFormattedMonthAndYear(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_NO_MONTH_DAY);
    }

    /**
     * @return readable date ->  Tuesday, August 12, 2014, 8:58 PM (everything combined)
     */
    public static String getFormattedDateTimeComplete(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE |
                DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_WEEKDAY);
    }

    /**
     * @return readable date ->  Tue, Aug 12, 2014, 8:58 PM (everything abbreviated)
     */
    public static String getFormattedAbbreviatedDateTimeComplete(Context ctx, long millis) {
        return DateUtils.formatDateTime(ctx, millis, DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE |
                DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_WEEKDAY | DateUtils.FORMAT_ABBREV_ALL);
    }


    /**
     * <p>
     * Converts timestamp in seconds to Human readable string
     * Its hours based:
     * ie. moments ago, 15 minutes ago, 5 days ago
     * else default fallback date is returned.
     * </p>
     *
     * @param fallbackDatePattern - Date Pattern
     *                            default is MMM dd, yyyy
     * @param timeInSeconds       - Timestamp in seconds
     * @return Human readable.
     */
    public static String getTimeDiffHoursBased(long timeInSeconds, @Nullable String fallbackDatePattern) {

        long currentTime = System.currentTimeMillis() / 1000L;
        long delta = currentTime - timeInSeconds;
        final String pattern = fallbackDatePattern == null || fallbackDatePattern.length() == 0 ? "MMM dd, yyyy" : fallbackDatePattern;
        String str = "";

        long aDay = 60L * 60 * 24;
        long anHour = 60L * 60;
        long aMinute = 60L;

        if (delta < aMinute * 2) {
            str = "moments ago";
        } else if (delta >= aMinute * 2 && delta < anHour) {
            str = (delta / aMinute) + " minutes ago";
        } else if (delta >= anHour && delta < aDay) {
            str = (delta / anHour) + " hours ago";
        } else if (delta >= aDay && delta < aDay * 7) {
            str = (delta / aDay) + " days ago";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
            Date netDate = (new Date(timeInSeconds * 1000L));
            str = sdf.format(netDate);
        }

        return str;

    }

    /**
     * <p>
     * Converts timestamp in seconds to Human readable string
     * Its Days based:
     * ie. today, yesterday
     * else default fallback date is returned.
     * </p>
     *
     * @param fallbackDatePattern - Date Pattern
     *                            default is MMM dd, yyyy
     * @param timeInSeconds       - Timestamp in seconds
     * @return Human readable.
     */
    public static String getTimeDiffDaysBased(long timeInSeconds, @Nullable String fallbackDatePattern) {
        long secondsInOneDay = 84600;
        int maxDaysAgo = 10;

        long currentTime = System.currentTimeMillis() / 1000L;
        long secondsTimeDiff = currentTime - timeInSeconds;

        final String pattern = fallbackDatePattern == null || fallbackDatePattern.length() == 0 ? "MMM dd, yyyy" : fallbackDatePattern;

        if (secondsTimeDiff < secondsInOneDay) {
            return "today";
        } else if (secondsTimeDiff < 2 * secondsInOneDay) {
            return "yesterday";
        } else if (secondsTimeDiff < maxDaysAgo * secondsInOneDay) {
            int days = (int) (secondsTimeDiff / secondsInOneDay);
            return days + " days ago";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
            Date netDate = (new Date(timeInSeconds * 1000L));
            return sdf.format(netDate);
        }
    }


    public static boolean isToday(long millis) {
        return DateUtils.isToday(millis);
    }

    /**
     * @param t1,t2 - Time either in Seconds or Milliseconds (both should be same format)
     * @return - 0 if equal ; 1 if first is greater ; -1 is first is smaller
     */
    public static int compare(long t1, long t2) {
        if (t1 == t2)
            return 0;
        if (t1 > t2)
            return 1;
        return -1;
    }

    public static long addHours(long targetInMillis, int hours) {
        int addedMillis = 60 * 60 * 1000 * hours;
        return targetInMillis + addedMillis;
    }

    public static Date addHours(@NonNull Date target, int hours) {
        int addedMillis = 60 * 60 * 1000 * hours;
        target.setTime(target.getTime() + addedMillis);
        return target;
    }

    public static long subtractHours(long targetInMillis, int hours) {
        int addedMillis = 60 * 60 * 1000 * hours;
        return targetInMillis - addedMillis;
    }

    public static Date subtractHours(@NonNull Date target, int hours) {
        int addedMillis = 60 * 60 * 1000 * hours;
        target.setTime(target.getTime() - addedMillis);
        return target;
    }


    public static long addMinutes(long targetInMillis, int minutes) {
        int addedMillis = 60 * 1000 * minutes;
        return targetInMillis + addedMillis;
    }

    public static Date addMinutes(@NonNull Date target, int minutes) {
        int addedMillis = 60 * 1000 * minutes;
        target.setTime(target.getTime() + addedMillis);
        return target;
    }

    public static long subtractMinutes(long targetInMillis, int minutes) {
        int addedMillis = 60 * 1000 * minutes;
        return targetInMillis - addedMillis;
    }

    public static Date subtractMinutes(@NonNull Date target, int minutes) {
        int addedMillis = 60 * 1000 * minutes;
        target.setTime(target.getTime() - addedMillis);
        return target;
    }

    public static long addSeconds(long targetInMillis, int seconds) {
        int addedMillis = 1000 * seconds;
        return targetInMillis + addedMillis;
    }

    public static Date addSeconds(@NonNull Date target, int seconds) {
        int addedMillis = 1000 * seconds;
        target.setTime(target.getTime() + addedMillis);
        return target;
    }

    public static long subtractSeconds(long targetInMillis, int seconds) {
        int addedMillis = 1000 * seconds;
        return targetInMillis - addedMillis;
    }

    public static Date subtractSeconds(@NonNull Date target, int seconds) {
        int addedMillis = 1000 * seconds;
        target.setTime(target.getTime() - addedMillis);
        return target;
    }


}

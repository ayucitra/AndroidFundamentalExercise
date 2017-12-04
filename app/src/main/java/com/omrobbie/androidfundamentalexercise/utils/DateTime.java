package com.omrobbie.androidfundamentalexercise.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by omrobbie on 04/12/2017.
 */

public class DateTime {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private static String formatDate(String date, String format) {
        String result = "";
        if (date == null) date = "";

        try {
            Date oldDate = simpleDateFormat.parse(date);
            DateFormat newFormat = new SimpleDateFormat(format);
            result = newFormat.format(oldDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getShortDate(String date) {
        return formatDate(date, "dd MMMM yyyy");
    }

    public static String getLongDate(String date) {
        return formatDate(date, "EEEE, MMM d, yyyy");
    }

    public static boolean isGreaterThanNow(String date) {
        boolean isGreater = false;
        if (date == null) date = "";

        try {
            Date parseDate = simpleDateFormat.parse(date);
            Date now = Calendar.getInstance().getTime();

            if (now.compareTo(parseDate) < 0) isGreater = true;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isGreater;
    }
}

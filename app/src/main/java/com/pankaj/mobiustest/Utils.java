package com.pankaj.mobiustest;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String getDateAndTime(Context context, String dateTime) {
        String formattedTime = "--";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat output = new SimpleDateFormat("ddMMM,yyyy HH:mm aa", Locale.getDefault());
        Date d = null;
        try {
            d = sdf.parse(dateTime);
            formattedTime = output.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedTime;
    }
}

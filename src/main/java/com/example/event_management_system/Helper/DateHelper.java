package com.example.event_management_system.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    // Date +14 days and convert to String
    public static Date getFutureDate(Date date){
        long time = date.getTime();
        time += 15 * 24 * 60 * 60 * 1000;
        return new Date(time);
    }
}

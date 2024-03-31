package com.example.event_management_system.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    // Get date of 14 days from now
    public static Date getFutureDate(){
        Date date = new Date();
        long time = date.getTime();
        time += 14 * 24 * 60 * 60 * 1000;
        return new Date(time);
    }
}

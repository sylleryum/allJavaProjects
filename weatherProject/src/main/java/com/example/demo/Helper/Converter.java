package com.example.demo.Helper;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Converter {

    public static Double KevinToC (Double kevin){

        //C = K - 273,15

        return kevin - 273.15;
    }
    //1 dia = 86400000
    /**
     @param mili = time in miliseconds
     @return time in the following String format: 12-30-2017 00:00:00 AM/PM
     */
    public static String convertMiliToDate(long mili) {
//        if(mili<1514772000000l){
//            mili *= 1000;
//        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        String data;

        data = calendar.get(Calendar.DAY_OF_MONTH)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+
                calendar.get(Calendar.YEAR)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);
        //System.out.println(data);
        return data;
    }

    /**
     @param mili = time in miliseconds
     @return time in the following String format: 24:00
     */
    public static String convertMiliToHour(long mili) {
//        if(mili<1514772000000l){
//            mili *= 1000;
//        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        String data;

        data = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);
        //System.out.println(data);
        return data;
    }

    /**
     @param mili = time in miliseconds
     @return time in the following String format: 24 hours
     */
    public static int getHour(long mili) {
//        if(mili<1514772000000l){
//            mili *= 1000;
//        }
        //TimeZone timeZone = TimeZone.getTimeZone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        String data;

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     @param mili = time in miliseconds
     @return day of the month
     */
    public static int getDay(long mili) {
//        if(mili<1514772000000l){
//            mili *= 1000;
//        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        String data;

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     @param mili = time in miliseconds
     @return day of the month and week (name in PT, ex: 11 segunda-feira)
     */
    public static String getDayMw (long mili){
        String[] daysPT = new String[]{"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira",
        "Sexta-feira", "Sabado"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mili);
        //calendar.get(Calendar.HOUR_OF_DAY);
        return getDay(mili) + " " + daysPT[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    /**
     * Get now date as milliseconds
     */
    public static Long getNowDateMil() {
        return new Date().getTime();
    }
}

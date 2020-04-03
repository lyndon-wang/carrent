package com.rent.carrentcommon.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * craete dateutil by lydon
 */
public class DateUtil {

    /**
     * return current time format
     * @param pattern
     * @return
     */
    public static String getCurrentTimeByFormat (String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     *
     * return time format
     * @param days
     * @param pattern
     * @return
     */
    public static String  getSeveralDaysByFormat (long days, String pattern) {
        return  LocalDateTime.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }


    public static void main(String[] args) {
        System.out.println(getSeveralDaysByFormat(-1, "yyyy-MM-dd HH:mm:ss"));
    }

}

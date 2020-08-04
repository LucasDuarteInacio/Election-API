package com.project.Electionapi.util;
import java.util.Date;

public final class DateUtil {

    private DateUtil() {
        throw new IllegalStateException("DateUtil class");
    }

    public static boolean isDateActive(Date date) {
        Date dateNow = new Date();
        return dateNow.compareTo(date) <=0;


    }
}
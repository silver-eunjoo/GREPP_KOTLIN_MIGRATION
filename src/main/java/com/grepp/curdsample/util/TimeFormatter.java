package com.grepp.curdsample.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {

    private static final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static LocalDate convertToLocalDate(String localDateStr) {
//        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(localDateStr, pattern);
    }

    public static String convertToStr(LocalDate localDate) {
        return localDate.format(pattern);
    }

    public static String convertToStr(LocalDateTime localDate) {
        return localDate.format(pattern);
    }

}

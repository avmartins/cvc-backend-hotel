package com.herokuapp.cvcbackendhotel.service.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {

    private LocalDateUtil() {}

    public static Long getTotalDoPeridoDeDias(String dataIn, String dataOut) {
        return Duration.between(transformToLocalDateTimePatterBrazilian(dataIn),
        		transformToLocalDateTimePatterBrazilian(dataOut)).toDays();
    }

    private static String addTime(String data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(data);
        stringBuilder.append(" ");
        stringBuilder.append("00:00:00");
        return stringBuilder.toString();
    }

    private static LocalDateTime transformToLocalDateTimePatterBrazilian(String data) {
        return convertSringToLocalDate(data.replace("-", "/"), "dd/MM/yyyy HH:mm:ss");
    }

    private static LocalDateTime convertSringToLocalDate(String data, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(addTime(data),formatter);
    }

}

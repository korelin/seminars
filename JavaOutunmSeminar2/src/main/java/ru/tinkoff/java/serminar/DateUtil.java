package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;

public class DateUtil {
    public static boolean isSameDay(LocalDateTime day1, LocalDateTime day2) {
        if (day1 == null || day2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return day1.getYear() == day2.getYear() && day1.getDayOfYear() == day2.getDayOfYear();
    }
}

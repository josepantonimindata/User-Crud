package me.team.usercrud.shared.domain.services;

import java.time.LocalDateTime;

public final class DatetimeUtils {
    public static String getNowTimeInString() {
        return LocalDateTime.now().toString();
    }
}

package me.team.usercrud.shared.domain.services;

import org.springframework.lang.NonNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtils {
    @NonNull
    public static String getNowTimeInString() {
        return LocalDateTime.now().toString();
    }
    
    @NonNull
    public static String dateToString(@NonNull LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    @NonNull
    public static String dateToString(@NonNull Timestamp timestamp) {
        return dateToString(timestamp.toLocalDateTime());
    }
    
}

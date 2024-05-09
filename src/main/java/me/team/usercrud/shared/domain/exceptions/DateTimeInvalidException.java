package me.team.usercrud.shared.domain.exceptions;

import org.springframework.lang.NonNull;

public class DateTimeInvalidException extends IllegalArgumentException {
    public DateTimeInvalidException(@NonNull String value) {
        super("Value is not a valid DateTime - value : " + value);
    }
}

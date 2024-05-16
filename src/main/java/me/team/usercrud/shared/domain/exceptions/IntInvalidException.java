package me.team.usercrud.shared.domain.exceptions;

import org.springframework.lang.NonNull;

public class IntInvalidException extends IllegalArgumentException {
    public IntInvalidException(@NonNull String value) {
        super("Identifier value is not a valid Natural Number - value : " + value);
    }
}

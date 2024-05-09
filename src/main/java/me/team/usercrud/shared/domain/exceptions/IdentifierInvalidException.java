package me.team.usercrud.shared.domain.exceptions;

import org.springframework.lang.NonNull;

public class IdentifierInvalidException extends IllegalArgumentException {
    public IdentifierInvalidException(@NonNull String value) {
        super("Identifier is not a valid UUID - value : " + value);
    }
}

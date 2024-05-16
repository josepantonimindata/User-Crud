package me.team.usercrud.shared.domain.exceptions;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class NullArgumentException extends IllegalArgumentException {
    private final Optional<String> field;
    
    public NullArgumentException() {
        super("The argument passed to function as 'null'");
        this.field = Optional.empty();
    }
    
    public NullArgumentException(@NonNull String field) {
        super("The argument passed to function as 'null' for field: " + field);
        this.field = Optional.of(field);
    }
    
    public NullArgumentException(@NonNull String message, @Nullable String field) {
        super(message);
        this.field = Optional.ofNullable(field);
    }
    
    public Optional<String> field() {
        return this.field;
    }
}

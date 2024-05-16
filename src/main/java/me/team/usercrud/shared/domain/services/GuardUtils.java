package me.team.usercrud.shared.domain.services;

import me.team.usercrud.shared.domain.exceptions.NullArgumentException;
import org.springframework.lang.Nullable;

public class GuardUtils {
    
    public static void isNotNull(@Nullable Object value) throws NullArgumentException {
        if (value == null) {
            throw new NullArgumentException();
        }
    }
}

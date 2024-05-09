package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.objects.DateTimeValueObject;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public final class UserLastEditTime extends DateTimeValueObject {
    public UserLastEditTime(@NonNull String dateTime) {
        super(dateTime);
        guard(this.value);
    }
    
    public static UserLastEditTime now() {
        return new UserLastEditTime(LocalDateTime.now().toString());
    }
    
    // Check is not created in the future
    private void guard(LocalDateTime dateTime) {
        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A user can not bee modified in the future");
        }
    }
}

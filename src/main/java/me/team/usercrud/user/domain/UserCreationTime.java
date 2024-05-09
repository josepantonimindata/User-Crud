package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.objects.DateTimeValueObject;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public final class UserCreationTime extends DateTimeValueObject {
    public UserCreationTime(@NonNull String dateTime) {
        super(dateTime);
        guard(this.value);
    }
    
    public static UserCreationTime now() {
        return new UserCreationTime(LocalDateTime.now().toString());
    }
    
    // Check is not created in the future
    private void guard(LocalDateTime dateTime) {
        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A user can not bee Created in the future");
        }
    }
}

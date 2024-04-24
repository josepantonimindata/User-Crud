package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.DatetimeValueObject;

import java.time.LocalDateTime;

public final class UserCreationTime extends DatetimeValueObject {
    public UserCreationTime(String dateTime) {
        super(dateTime);
        guard(value());
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

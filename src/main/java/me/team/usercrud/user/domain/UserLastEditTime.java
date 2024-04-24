package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.DatetimeValueObject;

import java.time.LocalDateTime;

public final class UserLastEditTime extends DatetimeValueObject {
    public UserLastEditTime(String dateTime) {
        super(dateTime);
        guard(value());
    }

    public static UserLastEditTime now() {
        return new UserLastEditTime(LocalDateTime.now().toString());
    }

    // check is not future
    private void guard(LocalDateTime dateTime) {
        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A user can not bee modified in the future");
        }
    }
}

package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.objects.StringValueObject;

public final class UserSurname extends StringValueObject {
    public UserSurname(String value) {
        super(guard(value));
    }

    private static String guard(String value) {
        if (value.length() < 2) {
            throw new IllegalArgumentException("UserName value must contain at least twi characters");
        }
        return value;
    }
}

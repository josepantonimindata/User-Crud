package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.RegexValidator;
import me.team.usercrud.shared.domain.StringValueObject;

/**
 * - at least 8 characters
 * - must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number
 * - Can contain special characters
 * */
public final class UserPassword extends StringValueObject {
    private static final String regex = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g";
    private static final RegexValidator regexValidator = new RegexValidator(regex);

    public UserPassword(String value) {
        super(guard(value));
    }

    private static String guard(String value) {
        if (regexValidator.validate(value)) {
            throw new IllegalArgumentException("Invalid Email");
        }
        return value;
    }
}

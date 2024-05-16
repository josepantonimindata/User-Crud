package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.RegexValidator;
import me.team.usercrud.shared.domain.objects.StringValueObject;

/**
 * - at least eight characters
 * - must contain at least one uppercase letter, one lowercase letter, and one number
 * - Can contain special characters
 */
public final class UserPassword extends StringValueObject {
    private static final String regex = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g";
    private static final RegexValidator regexValidator = new RegexValidator(regex);
    
    public UserPassword(String value) {
        super(value);
        guard(value);
    }
    
    private String guard(String value) {
        if (regexValidator.validate(value)) {
            throw new IllegalArgumentException("Invalid password");
        }
        return value;
    }
}

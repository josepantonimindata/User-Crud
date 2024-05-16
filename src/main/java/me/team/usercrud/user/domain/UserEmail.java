package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.RegexValidator;
import me.team.usercrud.shared.domain.objects.StringValueObject;

/**
 * Email Validation as per RFC2822 standards.
 */
public final class UserEmail extends StringValueObject {
    private static final String regex = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g";
    private static final RegexValidator regexValidator = new RegexValidator(regex);
    
    public UserEmail(String value) {
        super(guard(value));
    }
    
    private static String guard(String value) {
        if (regexValidator.validate(value)) {
            throw new IllegalArgumentException("Invalid Email");
        }
        return value;
    }
}

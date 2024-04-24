package me.team.usercrud.shared.domain;

import java.util.regex.Pattern;

public final class RegexValidator {
    private final Pattern pattern;

    public RegexValidator(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean validate(String value) {
        var matcher = pattern.matcher(value);
        return matcher.matches();
    }
}

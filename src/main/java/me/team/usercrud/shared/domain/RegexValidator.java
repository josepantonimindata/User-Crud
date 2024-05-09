package me.team.usercrud.shared.domain;

import org.springframework.lang.NonNull;

import java.util.regex.Pattern;

public final class RegexValidator {
    @NonNull
    private final Pattern pattern;
    
    public RegexValidator(@NonNull String regex) {
        this.pattern = Pattern.compile(regex);
    }
    
    public boolean validate(@NonNull String value) {
        var matcher = pattern.matcher(value);
        return matcher.matches();
    }
}

package me.team.usercrud.domain;

import java.util.UUID;

public class UserID extends StringValueObject{
    public UserID(String value) {
        super(value);
        try {
            var uuid = UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

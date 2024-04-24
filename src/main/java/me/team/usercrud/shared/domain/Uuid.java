package me.team.usercrud.shared.domain;


import java.util.UUID;


public abstract class Uuid extends StringValueObject {
    public Uuid(String value) {
        super(UUID.fromString(value).toString());
    }
}


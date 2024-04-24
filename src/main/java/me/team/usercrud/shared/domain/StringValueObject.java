package me.team.usercrud.shared.domain;

import java.util.Objects;


public abstract class StringValueObject {
    private final String value;

    public StringValueObject(String value) {
        if (value == null) {
            throw new IllegalArgumentException(this.getClass().getName() + " can not be null");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

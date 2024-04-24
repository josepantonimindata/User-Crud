package me.team.usercrud.shared.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ISO-8601 String format
 */
public abstract class DatetimeValueObject implements Comparable<DatetimeValueObject> {
    private final LocalDateTime dateTime;

    public DatetimeValueObject(String datetime) {
        this.dateTime = LocalDateTime.parse(datetime);
    }

    public LocalDateTime value() {
        return dateTime;
    }

    public String stingValue() {
        return dateTime.toString();
    }

    public boolean isAfter(DatetimeValueObject other) {
        return dateTime.isAfter(other.value());
    }

    public boolean isBefore(DatetimeValueObject other) {
        return dateTime.isBefore(other.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatetimeValueObject that = (DatetimeValueObject) o;
        return Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }

    @Override
    public int compareTo(DatetimeValueObject o) {
        if (this.isBefore(o)) {
            return -1;
        }
        if (this.isAfter(o)) {
            return 1;
        }

        return 0;
    }
}

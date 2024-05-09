package me.team.usercrud.shared.domain.objects;

import me.team.usercrud.shared.domain.exceptions.DateTimeInvalidException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import static me.team.usercrud.shared.domain.services.GuardUtils.isNotNull;


/**
 * This abstract class represents a DateTime value object.
 */
public abstract class DateTimeValueObject implements Comparable<DateTimeValueObject> {
    protected final LocalDateTime value;
    
    /**
     *
     */
    protected DateTimeValueObject(@NonNull String value) {
        isNotNull(value);
        this.value = ensureValidDateTime(value);
    }
    
    /**
     * Ensure that the provided value is a valid LocalDateTime.
     *
     * @param value the value to be validated
     * @return the parsed LocalDateTime representation of the value
     * @throws DateTimeInvalidException if the value is not a valid LocalDateTime
     */
    private LocalDateTime ensureValidDateTime(@NonNull String value) {
        try {
            return LocalDateTime.parse(value);
        } catch (DateTimeParseException e) {
            throw new DateTimeInvalidException(value);
        }
    }
    
    /**
     * Returns the string representation of the value.
     *
     * @return the string representation of the value
     */
    @NonNull
    public String value() {
        return value.toString();
    }
    
    /**
     * Compares this DateTimeValueObject to the specified DateTimeValueObject.
     * <p>
     * The comparison is based on the value of the DateTimeValueObject.
     * <p>
     * This method overrides the compareTo method of the Comparable interface.
     *
     * @param other the DateTimeValueObject to be compared
     * @return a negative integer, zero, or a positive integer as this DateTimeValueObject is less than, equal to,
     * or greater than the specified DateTimeValueObject
     */
    @Override
    public int compareTo(@Nonnull DateTimeValueObject other) {
        isNotNull(other);
        
        return value.compareTo(other.value);
    }
    
    /// Generated Methods
    
    /**
     * Returns the hash code value for this DateTimeValueObject.
     * <p>
     * The hash code is calculated using the value of the DateTimeValueObject.
     *
     * @return the hash code value for this DateTimeValueObject
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    /**
     * Checks if this DateTimeValueObject is equal to the specified object.
     * Equality is determined by comparing the value of the DateTimeValueObject.
     *
     * @param o the object to compare this DateTimeValueObject against
     * @return true if the specified object is equal to this DateTimeValueObject, false otherwise
     */
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeValueObject that = (DateTimeValueObject) o;
        return Objects.equals(value, that.value);
    }
}

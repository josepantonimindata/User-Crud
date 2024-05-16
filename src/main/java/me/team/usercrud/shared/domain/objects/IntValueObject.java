package me.team.usercrud.shared.domain.objects;

import me.team.usercrud.shared.domain.exceptions.IntInvalidException;
import me.team.usercrud.shared.domain.exceptions.NullArgumentException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

import static me.team.usercrud.shared.domain.services.GuardUtils.isNotNull;

public abstract class IntValueObject {
    protected final int value;
    
    /**
     * Constructs a new IntValueObject with the given value.
     *
     * @param value the string value to be converted to an integer
     * @throws IntInvalidException   if the string value is not a valid integer
     * @throws NullArgumentException if the value is null
     */
    protected IntValueObject(@NonNull String value) {
        isNotNull(value);
        
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IntInvalidException(value);
        }
    }
    
    /**
     * Constructs a new IntValueObject with the given value.
     *
     * @param value the integer value of the IntValueObject
     * @throws NullArgumentException if the value is null
     */
    protected IntValueObject(@NonNull Integer value) {
        isNotNull(value);
        
        this.value = value;
    }
    
    /**
     * Constructs a new IntValueObject with the given value.
     *
     * @param value the integer value of the IntValueObject
     */
    public IntValueObject(int value) {
        this.value = value;
    }
    
    public int value() {
        return value;
    }
    
    /// Generated Methods
    
    /**
     * Compares this IntValueObject with the specified object for equality.
     *
     * @param o the object to compare to this IntValueObject
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntValueObject that = (IntValueObject) o;
        return value == that.value;
    }
    
    /**
     * Returns the hash code value for this IntValueObject.
     *
     * @return the hash code value for this IntValueObject
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

package me.team.usercrud.shared.domain.objects;

import me.team.usercrud.shared.domain.exceptions.IdentifierInvalidException;
import me.team.usercrud.shared.domain.exceptions.NullArgumentException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.UUID;

import static me.team.usercrud.shared.domain.services.GuardUtils.isNotNull;

public abstract class Identifier {
    protected final UUID value;
    
    /**
     * Creates a new Identifier object with the specified value.
     *
     * @param value the value of the identifier
     * @throws NullArgumentException    if the value is null
     * @throws IllegalArgumentException if the value is not valid, UUID
     */
    protected Identifier(@NonNull String value) {
        isNotNull(value);
        this.value = ensureValidUuid(value);
    }
    
    /**
     * Creates a new Identifier object with the specified value.
     *
     * @param value the value of the identifier
     * @throws NullArgumentException if the value is null
     */
    protected Identifier(UUID value) {
        isNotNull(value);
        this.value = value;
    }
    
    /**
     * Retrieves the string representation of the value.
     *
     * @return the string representation of the value
     */
    public String value() {
        return value.toString();
    }
    
    /**
     * Ensures that the given value is a valid UUID.
     *
     * @param value the string representation of the UUID
     * @return the UUID object if the value is valid
     * @throws IdentifierInvalidException if the value is not valid, UUID
     */
    private UUID ensureValidUuid(String value) {
        try {
            return UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new IdentifierInvalidException(value);
        }
    }
    
    /// Generated Methods
    
    /**
     * Compares this Identifier object with the specified object for equality.
     * Returns true if and only if the specified object is also an Identifier object
     * and both objects have the same value.
     *
     * @param o the object to be compared for equality with this Identifier
     * @return true if the specified object is equal to this Identifier, false otherwise
     */
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }
    
    /**
     * Computes the hash code for this Identifier object.
     * The hash code is computed based on the value of the identifier.
     *
     * @return the hash code value for this Identifier
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

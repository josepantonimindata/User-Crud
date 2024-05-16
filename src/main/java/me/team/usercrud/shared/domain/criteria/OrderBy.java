package me.team.usercrud.shared.domain.criteria;

import me.team.usercrud.shared.domain.objects.StringValueObject;
import org.springframework.lang.NonNull;

public class OrderBy extends StringValueObject {
    public OrderBy(@NonNull String value) {
        super(value);
    }
}

package me.team.usercrud.shared.domain.criteria;

import me.team.usercrud.shared.domain.objects.StringValueObject;
import org.springframework.lang.NonNull;

public class FilterField extends StringValueObject {
    public FilterField(@NonNull String value) {
        super(value);
    }
}

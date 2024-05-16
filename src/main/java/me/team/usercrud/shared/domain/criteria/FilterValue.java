package me.team.usercrud.shared.domain.criteria;

import me.team.usercrud.shared.domain.objects.StringValueObject;
import org.springframework.lang.NonNull;

public class FilterValue extends StringValueObject {
    public FilterValue(@NonNull String value) {
        super(value);
    }
}

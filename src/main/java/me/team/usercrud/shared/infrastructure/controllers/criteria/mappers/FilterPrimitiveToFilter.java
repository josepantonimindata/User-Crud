package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.FilterOperator;
import me.team.usercrud.shared.domain.exceptions.NullArgumentException;
import me.team.usercrud.shared.infrastructure.controllers.criteria.FilterPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FilterPrimitiveToFilter implements Mapper<FilterPrimitive, Filter> {
    @NonNull
    @Override
    public Filter map(@NonNull FilterPrimitive filterPrimitive) {
        
        if (filterPrimitive.getField() == null) {
            throw new NullArgumentException("Field of a Filter cannot be null");
        }
        
        if (filterPrimitive.getValue() == null) {
            throw new NullArgumentException("Value of a Filer cannot be null");
        }
        
        return Filter.from(
            filterPrimitive.getField(),
            FilterOperator.valueOf(filterPrimitive.getOperator()),
            filterPrimitive.getValue()
        );
    }
}

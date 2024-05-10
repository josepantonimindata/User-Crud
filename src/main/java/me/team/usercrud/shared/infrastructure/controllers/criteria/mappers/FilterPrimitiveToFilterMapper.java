package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.FilterOperator;
import me.team.usercrud.shared.infrastructure.controllers.criteria.FilterPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FilterPrimitiveToFilterMapper implements Mapper<FilterPrimitive, Filter> {
    @NonNull
    @Override
    public Filter map(@NonNull FilterPrimitive filterPrimitive) {
        return Filter.from(
            filterPrimitive.getField(),
            FilterOperator.valueOf(filterPrimitive.getOperator()),
            filterPrimitive.getValue()
        );
    }
}

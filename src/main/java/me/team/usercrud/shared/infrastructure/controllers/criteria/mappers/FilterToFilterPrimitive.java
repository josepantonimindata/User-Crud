package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.infrastructure.controllers.criteria.FilterPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FilterToFilterPrimitive implements Mapper<Filter, FilterPrimitive> {
    @NonNull
    @Override
    public FilterPrimitive map(@NonNull Filter filter) {
        return new FilterPrimitive(
            filter.field().value(),
            filter.operator().toString(),
            filter.value().value()
        );
    }
}

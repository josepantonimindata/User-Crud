package me.team.usercrud.shared.infrastructure.dto.criteria;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.FilterOperator;
import org.springframework.stereotype.Component;

@Component
public class FilterMapper implements Mapper<FilterPrimitive, Filter> {
    @Override
    public Filter from(FilterPrimitive filterPrimitive) {
        return Filter.from(
            filterPrimitive.getField(),
            FilterOperator.valueOf(filterPrimitive.getOperator()),
            filterPrimitive.getValue()
        );
    }

    @Override
    public FilterPrimitive to(Filter filter) {
        return new FilterPrimitive(
            filter.field().value(),
            filter.operator().toString(),
            filter.value().value()
        );
    }
}

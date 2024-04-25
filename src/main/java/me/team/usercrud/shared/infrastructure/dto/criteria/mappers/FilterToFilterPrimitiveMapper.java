package me.team.usercrud.shared.infrastructure.dto.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.infrastructure.dto.criteria.FilterPrimitive;
import org.springframework.stereotype.Component;

@Component
public class FilterToFilterPrimitiveMapper implements Mapper<Filter, FilterPrimitive> {

    private final Mapper<FilterPrimitive, Filter> mapper;

    public FilterToFilterPrimitiveMapper(Mapper<FilterPrimitive, Filter> mapper) {this.mapper = mapper;}

    @Override
    public FilterPrimitive from(Filter filter) {
        return mapper.to(filter);
    }

    @Override
    public Filter to(FilterPrimitive filterPrimitive) {
        return mapper.from(filterPrimitive);
    }
}

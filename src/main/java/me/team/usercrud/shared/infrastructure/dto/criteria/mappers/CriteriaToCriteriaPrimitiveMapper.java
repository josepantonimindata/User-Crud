package me.team.usercrud.shared.infrastructure.dto.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.infrastructure.dto.criteria.CriteriaPrimitive;
import org.springframework.stereotype.Component;

@Component
public class CriteriaToCriteriaPrimitiveMapper implements Mapper<Criteria, CriteriaPrimitive> {

    private final Mapper<CriteriaPrimitive, Criteria> mapper;

    public CriteriaToCriteriaPrimitiveMapper(Mapper<CriteriaPrimitive, Criteria> mapper) {this.mapper = mapper;}

    @Override
    public CriteriaPrimitive from(Criteria criteria) {
        return mapper.to(criteria);
    }

    @Override
    public Criteria to(CriteriaPrimitive criteriaPrimitive) {
        return mapper.from(criteriaPrimitive);
    }
}

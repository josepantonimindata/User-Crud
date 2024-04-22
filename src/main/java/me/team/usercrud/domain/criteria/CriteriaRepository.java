package me.team.usercrud.domain.criteria;

import java.util.List;

public interface CriteriaRepository<T> {
    List<T> search(Criteria criteria);
}

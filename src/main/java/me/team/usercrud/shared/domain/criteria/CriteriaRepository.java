package me.team.usercrud.shared.domain.criteria;

import java.util.List;

public interface CriteriaRepository<T> {
    List<T> search(Criteria criteria);
}

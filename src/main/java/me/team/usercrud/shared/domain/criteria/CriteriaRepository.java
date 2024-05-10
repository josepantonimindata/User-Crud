package me.team.usercrud.shared.domain.criteria;

import org.springframework.lang.NonNull;

import java.util.List;

public interface CriteriaRepository<T> {
    @NonNull
    List<T> search(@NonNull Criteria criteria);
}

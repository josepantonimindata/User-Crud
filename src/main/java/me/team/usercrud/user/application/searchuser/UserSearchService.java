package me.team.usercrud.user.application.searchuser;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.shared.domain.criteria.Criteria;

import java.util.List;

public interface UserSearchService {
    List<User> search(Criteria criteria);
}

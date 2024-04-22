package me.team.usercrud.application.user;

import me.team.usercrud.domain.User;
import me.team.usercrud.domain.criteria.Criteria;

import java.util.List;

public interface UserSearchService {
    List<User> search(Criteria criteria);
}

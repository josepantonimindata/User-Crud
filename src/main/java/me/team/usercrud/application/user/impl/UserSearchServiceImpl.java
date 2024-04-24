package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserSearchService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.criteria.Criteria;
import me.team.usercrud.domain.criteria.CriteriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {

    private CriteriaRepository<User> userCriteriaRepository;

    @Override
    public List<User> search(Criteria criteria) {
        return userCriteriaRepository.search(criteria);
    }
}

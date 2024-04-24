package me.team.usercrud.user.application.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.user.application.UserSearchService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
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

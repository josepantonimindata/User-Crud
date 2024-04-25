package me.team.usercrud.user.application.searchuser;

import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
import me.team.usercrud.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    private final CriteriaRepository<User> userCriteriaRepository;

    public UserSearchService(CriteriaRepository<User> userCriteriaRepository) {
        this.userCriteriaRepository = userCriteriaRepository;
    }

    public List<User> search(Criteria criteria) {
        return userCriteriaRepository.search(criteria);
    }
}

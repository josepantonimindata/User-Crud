package me.team.usercrud.user.application.criteria;

import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
import me.team.usercrud.user.application.exceptions.IllegalCriteriaArgumentsException;
import me.team.usercrud.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCriteriaService {
    
    private final CriteriaRepository<User> userCriteriaRepository;
    
    public UserCriteriaService(CriteriaRepository<User> userCriteriaRepository) {
        this.userCriteriaRepository = userCriteriaRepository;
    }
    
    public List<User> search(Criteria criteria) {
        try {
            return userCriteriaRepository.search(criteria);
        } catch (Exception e) {
            throw new IllegalCriteriaArgumentsException(e.getMessage());
        }
    }
    
    public Page<User> search(Criteria criteria, Pageable pageable) {
        try {
            return userCriteriaRepository.search(criteria, pageable);
        } catch (Exception e) {
            throw new IllegalCriteriaArgumentsException(e.getMessage());
        }
    }
}

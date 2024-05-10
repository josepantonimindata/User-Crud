package me.team.usercrud.user.infrastructure.controllers.searchuser;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.infrastructure.controllers.criteria.CriteriaPrimitive;
import me.team.usercrud.user.application.criteria.UserCriteriaService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserSearchController {
    private final UserCriteriaService userCriteriaService;
    private final Mapper<User, UserRequest> userMapper;
    private final Mapper<CriteriaPrimitive, Criteria> criteriaMapper;
    
    public UserSearchController(
        UserCriteriaService userCriteriaService,
        Mapper<User, UserRequest> userMapper,
        Mapper<CriteriaPrimitive, Criteria> criteriaMapper
    ) {
        this.userCriteriaService = userCriteriaService;
        this.userMapper = userMapper;
        this.criteriaMapper = criteriaMapper;
    }
    
    @GetMapping("/users/search")
    public List<UserRequest> search(CriteriaPrimitive criteriaPrimitive) {
        var criteria = criteriaMapper.map(criteriaPrimitive);
        
        var users = userCriteriaService.search(criteria);
        
        return users.stream().map(userMapper::map).toList();
    }
}

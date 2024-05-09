package me.team.usercrud.user.infrastructure.controllers.searchuser;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.infrastructure.dto.UserDto;
import me.team.usercrud.shared.infrastructure.dto.criteria.CriteriaPrimitive;
import me.team.usercrud.user.application.criteria.UserCriteriaService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserSearchController {
    private final UserCriteriaService userCriteriaService;
    private final Mapper<UserRequest, User> userMapper;
    private final Mapper<CriteriaPrimitive, Criteria> criteriaMapper;

    public UserSearchController(UserCriteriaService userCriteriaService, Mapper<UserRequest, User> userMapper, Mapper<CriteriaPrimitive, Criteria> criteriaMapper) {
        this.userCriteriaService = userCriteriaService;
        this.userMapper = userMapper;
        this.criteriaMapper = criteriaMapper;
    }

    @GetMapping("/users/search")
    public List<UserRequest> search(CriteriaPrimitive criteriaPrimitive) {
        var criteria = criteriaMapper.from(criteriaPrimitive);
        var users = userCriteriaService.search(criteria);

        return users.stream().map(userMapper::to).toList();
    }
}

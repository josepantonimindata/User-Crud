package me.team.usercrud.user.infrastructure.controllers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.infrastructure.dto.UserDto;
import me.team.usercrud.shared.infrastructure.dto.criteria.CriteriaPrimitive;
import me.team.usercrud.user.application.searchuser.UserSearchService;
import me.team.usercrud.user.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserSearchController {
    private final UserSearchService userSearchService;
    private final Mapper<UserDto, User> userMapper;
    private final Mapper<CriteriaPrimitive, Criteria> criteriaMapper;

    public UserSearchController(UserSearchService userSearchService, Mapper<UserDto, User> userMapper, Mapper<CriteriaPrimitive, Criteria> criteriaMapper) {
        this.userSearchService = userSearchService;
        this.userMapper = userMapper;
        this.criteriaMapper = criteriaMapper;
    }

    @GetMapping("/users/search")
    public List<UserDto> search(CriteriaPrimitive criteriaPrimitive) {
        var criteria = criteriaMapper.from(criteriaPrimitive);

        var users = userSearchService.search(criteria);

        return users.stream().map(userMapper::to).toList();
    }
}

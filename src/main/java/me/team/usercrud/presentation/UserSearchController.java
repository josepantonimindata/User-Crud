package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.dto.UserDto;
import me.team.usercrud.application.dto.criteria.CriteriaMapper;
import me.team.usercrud.application.dto.criteria.CriteriaPrimitive;
import me.team.usercrud.application.user.UserSearchService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserSearchController {
    private UserSearchService userSearchService;
    private ModelMapper modelMapper;

    @GetMapping("/users/search")
    public List<UserDto> search(CriteriaPrimitive criteriaPrimitive) {
        var criteria = CriteriaMapper.from(criteriaPrimitive);

        var users = userSearchService.search(criteria);

        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }
}

package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.dto.UserDto;
import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserFinderController {

    private UserFinderService userFinderService;

    private UserDto getUser(String id) {
        User user = userFinderService.findUser(UUID.fromString(id));
        return null;
    }


}

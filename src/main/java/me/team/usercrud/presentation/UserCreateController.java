package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.dto.UserDto;
import me.team.usercrud.application.user.UserCreateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserCreateController {
   private UserCreateService userCreateService;

    @GetMapping("/user")
    public UserDto getUser(String id) {
       return null;
    }
}

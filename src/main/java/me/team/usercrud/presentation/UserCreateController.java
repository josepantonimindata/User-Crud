package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.dto.UserDto;
import me.team.usercrud.application.user.UserCreateService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UserCreateController {

   private UserCreateService userCreateService;

    @PostMapping("/user")
    public void createUser(@ModelAttribute User user) {
        User newUser = userCreateService.createUser(user);

        System.out.println("User created: " + newUser);
    }
}

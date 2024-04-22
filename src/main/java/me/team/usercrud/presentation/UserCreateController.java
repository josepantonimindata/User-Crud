package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserCreateService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserCreateController {

    private UserCreateService userCreateService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        User newUser = userCreateService.createUser(user);

        System.out.println("User created: " + newUser);
    }
}

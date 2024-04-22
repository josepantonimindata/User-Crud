package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserUpdateService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserUpdateController {

    private UserUpdateService userUpdateService;

    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody User user) {
        User updatedUser = userUpdateService.updateUser(user);

        System.out.println("User updated: " + updatedUser);
    }

}

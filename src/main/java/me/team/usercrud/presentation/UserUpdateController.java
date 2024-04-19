package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserUpdateService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserUpdateController {

    private UserUpdateService userUpdateService;

    @PutMapping("/user")
    public void updateUser(@ModelAttribute User user) {
        userUpdateService.updateUser(user);

    }

}

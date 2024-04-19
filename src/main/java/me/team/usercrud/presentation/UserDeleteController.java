package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserDeleteService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserDeleteController {

    private UserDeleteService userDeleteService;

    @DeleteMapping("/delete/{id}")
    private void deleteUserById(@PathVariable String id) {
        userDeleteService.deleteUserById(UUID.fromString(id));
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@ModelAttribute User user) {
        userDeleteService.deleteUser(user);
    }
}

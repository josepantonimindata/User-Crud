package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserDeleteService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserDeleteController {

    private UserDeleteService userDeleteService;

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        userDeleteService.deleteUserById(UUID.fromString(id));
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user) {
        userDeleteService.deleteUser(user);
    }
}

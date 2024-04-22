package me.team.usercrud.presentation;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserFinderController {

    private UserFinderService userFinderService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userFinderService.findUser(UUID.fromString(id));
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userFinderService.findAll();
    }


}

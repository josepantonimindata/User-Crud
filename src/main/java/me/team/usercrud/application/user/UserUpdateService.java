package me.team.usercrud.application.user;

import me.team.usercrud.domain.User;
import org.springframework.stereotype.Service;

public interface UserUpdateService {
    void updateUser(User user);
}

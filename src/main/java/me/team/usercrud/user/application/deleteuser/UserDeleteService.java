package me.team.usercrud.user.application.deleteuser;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;

import java.util.UUID;

public interface UserDeleteService {
    void deleteUserById(UserId id);

    void deleteUser(User user);
}

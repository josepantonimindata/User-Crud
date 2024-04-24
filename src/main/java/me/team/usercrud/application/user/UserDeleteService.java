package me.team.usercrud.application.user;

import me.team.usercrud.user.domain.User;

import java.util.UUID;

public interface UserDeleteService {
    void deleteUserById(UUID userID);

    void deleteUser(User user);
}

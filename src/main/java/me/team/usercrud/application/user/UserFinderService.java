package me.team.usercrud.application.user;

import me.team.usercrud.user.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserFinderService {
    User findUser(UUID userID);

    List<User> findAll();
}

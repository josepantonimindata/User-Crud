package me.team.usercrud.user.application;

import me.team.usercrud.user.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserFinderService {
    User findUser(UUID userID);

    List<User> findAll();
}

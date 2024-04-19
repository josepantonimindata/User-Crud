package me.team.usercrud.application.user;

import me.team.usercrud.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserFinderService {
    Optional<User> findUser(UUID userID);

    List<User> findAll();
}

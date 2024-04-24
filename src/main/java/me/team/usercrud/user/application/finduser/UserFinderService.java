package me.team.usercrud.user.application.finduser;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;

import java.util.List;
import java.util.UUID;

public interface UserFinderService {
    User findUser(UserId id);

    List<User> findAll();
}

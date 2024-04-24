package me.team.usercrud.user.application.finduser;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;

import java.util.List;

public interface UserFinderService {
    User findUser(UserId id);

    List<User> findAll();
}

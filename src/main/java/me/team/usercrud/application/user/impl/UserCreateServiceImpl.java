package me.team.usercrud.application.user.impl;

import me.team.usercrud.application.user.UserCreateService;
import me.team.usercrud.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserCreateServiceImpl implements UserCreateService {

    @Override
    public void createUser(User user) {
        throw new IllegalArgumentException("Method not implemented");
    }
}

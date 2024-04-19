package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserDeleteService;
import me.team.usercrud.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class UserDeleteServiceImpl implements UserDeleteService {
    private UserRepository userRepository;

    @Override
    public void deleteUserById(UUID userID) {
        userRepository.deleteById(userID);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
}

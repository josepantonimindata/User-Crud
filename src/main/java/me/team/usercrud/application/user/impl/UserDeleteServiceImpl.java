package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserDeleteService;
import me.team.usercrud.application.user.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class UserDeleteServiceImpl implements UserDeleteService {
    private UserRepository userRepository;

    @Override
    public void deleteUserById(UUID userID) {
        if (!userRepository.existsById(userID)) {
            throw new UserNotFoundException(userID);
        }

        userRepository.deleteById(userID);
    }

    @Override
    public void deleteUser(User user) {
        final var userId = user.getId();
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        userRepository.deleteById(userId);
    }
}

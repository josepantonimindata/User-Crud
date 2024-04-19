package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.application.user.exceptions.UserNotFoundException;
import me.team.usercrud.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserFinderServiceImpl implements UserFinderService {
    private UserRepository userRepository;

    @Override
    public Optional<User> findUser(UUID userID) {
        if (!userRepository.existsById(userID)) {
           throw new UserNotFoundException(userID);
        }
        return userRepository.findById(userID);
    }

    @Override
    public List<User> findAll() {
        var users = userRepository.findAll();
        if (users == null) {
            users = new ArrayList<>();
        }

        return users;
    }
}

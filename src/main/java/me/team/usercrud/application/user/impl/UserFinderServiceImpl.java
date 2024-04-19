package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserFinderServiceImpl implements UserFinderService {
    private UserRepository userRepository;

    @Override
    public User findUser(UUID userID) {
        return userRepository.find(userID);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import me.team.usercrud.application.user.UserCreateService;
import me.team.usercrud.application.user.exceptions.UserAlreadyExistsException;
import me.team.usercrud.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCreateServiceImpl implements UserCreateService {
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepository.save(user);
    }
}

package me.team.usercrud.user.application.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import me.team.usercrud.user.application.UserUpdateService;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
    private UserRepository userRepository;

    @Override
    public User updateUser(User user) {
        val id = user.getId();
        if (!userRepository.existsById(id)) {
           throw new UserNotFoundException(id);
        }
        return userRepository.save(user);
    }
}

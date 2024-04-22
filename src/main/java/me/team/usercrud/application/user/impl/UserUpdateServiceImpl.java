package me.team.usercrud.application.user.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import me.team.usercrud.application.user.UserUpdateService;
import me.team.usercrud.application.user.exceptions.UserNotFoundException;
import me.team.usercrud.domain.User;
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

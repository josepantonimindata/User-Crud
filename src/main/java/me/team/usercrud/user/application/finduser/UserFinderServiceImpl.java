package me.team.usercrud.user.application.finduser;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFinderServiceImpl implements UserFinderService {
    private final UserRepository userRepository;

    public UserFinderServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser(UserId id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        return userRepository.findById(id).get();
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

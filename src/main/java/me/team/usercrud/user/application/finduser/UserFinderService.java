package me.team.usercrud.user.application.finduser;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFinderService {
    private final UserRepository userRepository;

    public UserFinderService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String id) {

//        if (!userRepository.existsById(id)) {
//            throw new UserNotFoundException(id);
//        }
//        return userRepository.findById(id).get();
        return null;
    }

    public List<User> findAll() {
//        var users = userRepository.findAll();
//        if (users == null) {
//            users = new ArrayList<>();
//        }
//
//        return users;
        return null;
    }
}

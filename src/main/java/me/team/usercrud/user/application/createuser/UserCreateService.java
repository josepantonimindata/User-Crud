package me.team.usercrud.user.application.createuser;

import me.team.usercrud.user.application.exceptions.UserAlreadyExistsException;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {
    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String userId, String userName, String userSurname, String userEmail, String userPassword) {
        var user = User.create(userId, userName, userSurname, userEmail, userEmail);
        if (userRepository.existsById(user.id())) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepository.save(user);
    }
}

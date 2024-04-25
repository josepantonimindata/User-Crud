package me.team.usercrud.user.application.updateuser;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserUpdateService {
    private final UserRepository userRepository;

    public UserUpdateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password) {
        var oldUser = userRepository.findById(id);
        if (oldUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        var creationDate = oldUser.get().creationTime();
        var userLastEditTime = new UserLastEditTime(LocalDateTime.now().toString());
        return userRepository.save(new User(id, name, surname, email, password, creationDate, userLastEditTime));
    }
}

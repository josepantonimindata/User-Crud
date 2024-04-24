package me.team.usercrud.user.application.updateuser;

import lombok.AllArgsConstructor;
import lombok.val;
import me.team.usercrud.user.application.updateuser.UserUpdateService;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
    private UserRepository userRepository;

    @Override
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

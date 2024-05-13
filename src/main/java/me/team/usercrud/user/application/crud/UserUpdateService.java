package me.team.usercrud.user.application.crud;

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
    
    public User updateUser(String userId, String userName, String userSurname, String userEmail, String userPassword) {
        var oldUser = userRepository.findById(new UserId(userId));
        
        if (oldUser.isEmpty()) {
            throw new UserNotFoundException(new UserId(userId));
        }
        
        var creationDate = oldUser.get().creationTime();
        var userLastEditTime = new UserLastEditTime(LocalDateTime.now().toString());
        
        final var user = new User(
            new UserId(userId),
            new UserName(userName),
            new UserSurname(userSurname),
            new UserEmail(userEmail),
            new UserPassword(userPassword),
            creationDate,
            userLastEditTime
        );
        
        userRepository.save(user);
        
        return user;
    }
}

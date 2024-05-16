package me.team.usercrud.user.application.crud;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserDeleteService {
    private final UserRepository userRepository;
    
    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void deleteUserById(String userId) {
        final var id = new UserId(userId);
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        
        userRepository.deleteById(id);
    }
}

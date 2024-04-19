package me.team.usercrud.application.user;

import lombok.AllArgsConstructor;
import me.team.usercrud.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class UserDeleteService {
    private UserRepository userRepository;

    public void delete(UUID userID) {
        userRepository.deleteById(userID);
    }
}

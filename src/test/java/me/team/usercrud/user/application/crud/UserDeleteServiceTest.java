package me.team.usercrud.user.application.crud;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserDeleteServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Test
    void deleteUserById_validUserId_removesUser() {
        // Arrange
        UUID userId = UUID.randomUUID();
        UserId id = new UserId(userId.toString());
        UserDeleteService userDeleteService = new UserDeleteService(userRepository);

        Mockito.when(userRepository.existsById(Mockito.any(UserId.class))).thenReturn(true);

        // Act
        userDeleteService.deleteUserById(userId.toString());

        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    void deleteUserById_invalidUserId_throwsException() {
        // Arrange
        UUID userId = UUID.randomUUID();
        UserId id = new UserId(userId.toString());
        UserDeleteService userDeleteService = new UserDeleteService(userRepository);

        Mockito.when(userRepository.existsById(Mockito.any(UserId.class))).thenReturn(false);

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userDeleteService.deleteUserById(userId.toString()));
    }
}

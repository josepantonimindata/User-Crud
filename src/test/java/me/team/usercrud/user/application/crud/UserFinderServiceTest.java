package me.team.usercrud.user.application.crud;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserFinderServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Test
    void findUserShouldReturnUserIfExists() {
        UserFinderService userFinderService = new UserFinderService(userRepository);
        String testId = "cae5fc1e-7668-40c2-acc9-e03c3e64b7ed";
        User userExpected = User.create(new UserId(testId), new UserName("Bob"), new UserSurname("surname"),
                                        new UserEmail("email"), new UserPassword("password"));

        when(userRepository.findById(new UserId(testId))).thenReturn(Optional.of(userExpected));

        User userActual = userFinderService.findUser(testId);

        assertEquals(userExpected, userActual);
    }

    @Test
    void findUserShouldThrowExceptionIfUserDoesNotExist() {
        UserFinderService userFinderService = new UserFinderService(userRepository);
        String testId = "069f07d7-b3b3-445f-8956-9b21de7ce9a9";

        when(userRepository.findById(new UserId(testId))).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userFinderService.findUser(testId));
    }
}

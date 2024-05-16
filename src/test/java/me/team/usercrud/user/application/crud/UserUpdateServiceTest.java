package me.team.usercrud.user.application.crud;

import me.team.usercrud.shared.domain.services.DateTimeUtils;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserUpdateServiceTest {
    
    @MockBean
    private UserRepository userRepository;
    
    @Test
    void whenUpdateUserSuccess_thenReturnsUpdatedUser() {
        
        UserId userId = new UserId("990cd06f-b8f7-45a2-a7ad-0f41de7cbed6");
        UserName userName = new UserName("John");
        UserSurname userSurname = new UserSurname("Doe");
        UserEmail userEmail = new UserEmail("john.doe@example.com");
        UserPassword userPassword = new UserPassword("password");
        UserCreationTime creationTime = new UserCreationTime(DateTimeUtils.getNowTimeInString());
        UserLastEditTime lastEditTime = new UserLastEditTime(DateTimeUtils.getNowTimeInString());
        
        User oldUser = new User(userId, userName, userSurname, userEmail, userPassword, creationTime, lastEditTime);
        
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(oldUser));
        
        UserUpdateService userService = new UserUpdateService(userRepository);
        
        User newUser = userService.updateUser("990cd06f-b8f7-45a2-a7ad-0f41de7cbed6", "Jane", "Doe", "jane.doe@example.com", "new_password");
        
        assertEquals(new UserName("Jane"), newUser.name());
        assertEquals(new UserSurname("Doe"), newUser.surname());
        assertEquals(new UserEmail("jane.doe@example.com"), newUser.email());
        assertEquals(new UserPassword("new_password"), newUser.password());
    }
    
    @Test
    void whenUpdateUserAndUserDoesNotExist_thenReturnException() {
        UserUpdateService userService = new UserUpdateService(userRepository);
        
        when(userRepository.findById(new UserId("9ad79f5c-a194-43db-bde7-d2ccfc83adc3"))).thenReturn(java.util.Optional.empty());
        
        assertThrows(UserNotFoundException.class,
            () -> userService.updateUser("9ad79f5c-a194-43db-bde7-d2ccfc83adc3", "Jane", "Doe", "jane.doe@example.com", "new_password"));
    }
}

package me.team.usercrud.application.users;

import lombok.val;
import me.team.usercrud.user.application.deleteuser.UserDeleteService;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.application.deleteuser.UserDeleteServiceImpl;
import me.team.usercrud.user.domain.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


@SpringBootTest
public class UserDeleteServiceImplTest {

    private final UserDeleteService userDeleteService = new UserDeleteServiceImpl(new UserRepositoryInMemory());

    @Test
    public void testDeleteUserByExistingId() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        userDeleteService.deleteUserById(user.getId());
    }

    @Test
    public void testDeleteUserByNonExistingId() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c2"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        assertThrowsExactly(UserNotFoundException.class, () ->userDeleteService.deleteUserById(user.getId()));
    }

    @Test
    public void testDeleteUserByObjectWithValidId() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        userDeleteService.deleteUser(user);
    }

    @Test
    public void testDeleteUserByObjectWithInvalidId() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c2"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        assertThrowsExactly(UserNotFoundException.class, () ->userDeleteService.deleteUser(user));
    }
}

package me.team.usercrud.application.users;

import lombok.val;
import me.team.usercrud.application.user.exceptions.UserAlreadyExistsException;
import me.team.usercrud.application.user.impl.UserCreateServiceImpl;
import me.team.usercrud.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UserCreateServiceImplTest {
    private UserCreateServiceImpl createService = new UserCreateServiceImpl(new UserRepositoryInMemory());

    @Test
    public void testThatCreateUserWithValidID() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c3"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        assertEquals(user, createService.createUser(user));
    }

    @Test
    public void testThatCreateUserThrowsUserAlreadyExistsException() {
        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
        assertThrowsExactly(UserAlreadyExistsException.class, () -> createService.createUser(user));
    }
}

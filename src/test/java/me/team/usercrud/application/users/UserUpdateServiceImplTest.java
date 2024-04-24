package me.team.usercrud.application.users;

import lombok.val;
import me.team.usercrud.user.application.updateuser.UserUpdateService;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.application.updateuser.UserUpdateServiceImpl;
import me.team.usercrud.user.domain.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UserUpdateServiceImplTest {
    private UserUpdateService userUpdateService = new UserUpdateServiceImpl(new UserRepositoryInMemory());

    @Test
    public void testUpdateExistingUser() {
        val expected = new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "Esteve", "Llobera", "esteve@esteve.com", "somehash4");
        val result = userUpdateService.updateUser(expected);

        assertEquals(expected, result);
    }

    @Test
    public void testUpdateInexistingUser() {
        val expected = new User(UUID.fromString("9a493853-0650-4b7c-a748-7c1096f5a97d"), "Esteve", "Llobera", "esteve@esteve.com", "somehash4");
        assertThrowsExactly(UserNotFoundException.class, () -> userUpdateService.updateUser(expected));
    }
}

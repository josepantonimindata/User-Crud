package me.team.usercrud.application.users;

import lombok.val;
import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.application.user.exceptions.UserNotFoundException;
import me.team.usercrud.application.user.impl.UserFinderServiceImpl;
import me.team.usercrud.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UserFinderServiceImplTest {
    private UserFinderService finderService = new UserFinderServiceImpl(new UserRepositoryInMemory());

    @Test
    public void testFindUserByExistingUUID() {
        val expected = new User(UUID.fromString("fe3ad44e-2b84-4d11-9f35-8e570ff3d3e2"), "Josep Antoni", "Aguilo", "josep@josep.com", "somehash2");
        val result = finderService.findUser(expected.getId());

        assertEquals(expected, result);
        assertEquals(result.getId(), expected.getId());
        assertEquals(result.getName(), expected.getName());
        assertEquals(result.getEmail(), expected.getEmail());
        assertEquals(result.getSurname(), expected.getSurname());
    }

    @Test
    public void testFindWithInvalidId() {
        val uuid = UUID.fromString("fe3ad44e-2b84-4d11-9f35-8e570ff3d3e9");
        assertThrowsExactly(UserNotFoundException.class, () -> finderService.findUser(uuid));
    }

    @Test
    public void testFindAll() {
        List<User> expectedUsers = List.of(
                new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1"),
                new User(UUID.fromString("fe3ad44e-2b84-4d11-9f35-8e570ff3d3e2"), "Josep Antoni", "Aguilo", "josep@josep.com", "somehash2"),
                new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "Esteve", "Llobera", "esteve@esteve.com", "somehash3")
        );
        val resultUsers = finderService.findAll();

        assertEquals(resultUsers, expectedUsers);
    }
}

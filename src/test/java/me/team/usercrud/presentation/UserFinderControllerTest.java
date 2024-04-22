package me.team.usercrud.presentation;

import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserFinderControllerTest {

    private UserFinderController userFinderController;

    @Mock
    UserFinderService userFinderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userFinderController = new UserFinderController(userFinderService);
    }

    @Test
    void findAll() {
        when(userFinderService.findAll()).thenReturn(List.of(
                new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "John", "Doe", "email@gmail.com", "password")
        ));

        List<User> users = userFinderController.findAll();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("John", users.getFirst().getName());

        verify(userFinderService, times(1)).findAll();
    }

    @Test
    void getUser() {
        when(userFinderService.findUser(any())).thenReturn(new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "John", "Doe", "email@gmail.com", "password"));

        User user = userFinderController.getUser("9a493853-0650-4b7c-a748-6c1096f5a97d");

        assertNotNull(user);
        assertEquals("John", user.getName());

        verify(userFinderService, times(1)).findUser(any());
    }

}
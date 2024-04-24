package me.team.usercrud.presentation;

import me.team.usercrud.application.user.UserFinderService;
import me.team.usercrud.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserFinderControllerTest {

    private UserFinderController userFinderController;

    private MockMvc mockMvc;

    @Mock
    UserFinderService userFinderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userFinderController = new UserFinderController(userFinderService);
        mockMvc = MockMvcBuilders.standaloneSetup(userFinderController).build();
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

    @Test
    void findAllWithRequest() throws Exception {
        when(userFinderService.findAll()).thenReturn(List.of(
                new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "John", "Doe", "email@gmail.com", "password"),
                new User(UUID.fromString("10493853-0650-4b7c-a748-6c1096f5a97d"), "Jane", "Doe", "email@gmail.com", "password")
        ));

        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("John")));

        verify(userFinderService, times(1)).findAll();
    }

    @Test
    void getUserWithRequest() throws Exception {
        when(userFinderService.findUser(any())).thenReturn(new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "John", "Doe", "email@gmail.com", "password"));

        mockMvc.perform(get("/users/9a493853-0650-4b7c-a748-6c1096f5a97d")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John")));

        verify(userFinderService, times(1)).findUser(any());
    }

}

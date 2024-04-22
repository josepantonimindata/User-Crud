package me.team.usercrud.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.team.usercrud.application.user.UserCreateService;
import me.team.usercrud.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserCreateControllerTest {

    private UserCreateController userCreateController;

    @Mock
    private UserCreateService userCreateService;

    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userCreateController = new UserCreateController(userCreateService);
        mockMvc = MockMvcBuilders.standaloneSetup(userCreateController).build();
    }

    @Test
    void createUser() throws Exception {
        User user = new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "John", "Doe", "email@gmail.com", "password");
        when(userCreateService.createUser(user)).thenReturn(user);

        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
            .andExpect(status().isCreated());
    }
}
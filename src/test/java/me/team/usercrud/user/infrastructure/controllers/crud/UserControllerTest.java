package me.team.usercrud.user.infrastructure.controllers.crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    ObjectMapper objectMapper;
    
    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/users"))
            .andExpect(status().isOk());
    }
    
    @Test
    void testCreateUser() throws Exception {
        UserRequest user = new UserRequest(UUID.fromString("8a339182-b019-4573-bbd5-d5e6080778bf"),
            "John",
            "Doe",
            "john@doe.com",
            "password");
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isCreated());
    }
    
    @Test
    void testUpdateUser() throws Exception {
        UserRequest user = new UserRequest(UUID.fromString("8a339182-b019-4573-bbd5-d5e6080778bf"),
            "John",
            "Doe",
            "john@doe.com",
            "updatedpassword");
        mockMvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isNotFound());
    }
    
    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/users/{id}", UUID.fromString("8a339182-b019-4573-bbd5-d5e6080778bf")))
            .andExpect(status().isOk());
    }
}

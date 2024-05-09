package me.team.usercrud.shared.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Optional;

@Component
public class JsonService {
    private final ObjectMapper mapper;
    
    public JsonService(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    
    public Optional<String> jsonEncode(@NonNull HashMap<String, Serializable> map) {
        try {
            return Optional.of(mapper.writeValueAsString(map));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }
    
    @NonNull
    public Optional<HashMap<String, Serializable>> jsonDecode(@NonNull String body) {
        try {
            //noinspection unchecked
            return Optional.of(mapper.readValue(body, HashMap.class));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}

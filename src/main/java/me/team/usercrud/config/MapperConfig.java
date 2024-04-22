package me.team.usercrud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.modelmapper.convention.MatchingStrategies.LOOSE;


@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelmapper = new ModelMapper();
        modelmapper.getConfiguration().setMatchingStrategy(LOOSE);
        return modelmapper;
    }
}


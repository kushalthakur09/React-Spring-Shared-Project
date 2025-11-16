package com.example.backend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STANDARD)   // STANDARD or LOOSE if you prefer
        .setFieldMatchingEnabled(true)                      // enable field matching
        .setFieldAccessLevel(AccessLevel.PRIVATE)           // allow private field access
        .setMethodAccessLevel(AccessLevel.PUBLIC);
        return mapper;
    }
}

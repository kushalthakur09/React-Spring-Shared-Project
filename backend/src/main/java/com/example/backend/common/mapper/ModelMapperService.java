package com.example.backend.common.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperService {

    private final ModelMapper modelMapper;

    public ModelMapperService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public <T> T mapTo(Object source, Class<T> target){
        if(source == null) return null;
        return modelMapper.map(source,target);
    }
}

package com.example.backend.auth.mapper;

import com.example.backend.auth.dto.SignupDto;
import com.example.backend.auth.dto.UserDto;
import com.example.backend.auth.entity.UserEntity;
import com.example.backend.common.mapper.ModelMapperService;

public class UserMapper {

    private final ModelMapperService mapperService;

    public  UserMapper(ModelMapperService mapperService){
        this.mapperService=mapperService;
    }

    public UserDto toDto(UserEntity userEntity){
        return  mapperService.mapTo(userEntity,UserDto.class);
    }
     public SignupDto toSignupRequest(UserEntity userEntity){
        return mapperService.mapTo(userEntity, SignupDto.class);
     }
}

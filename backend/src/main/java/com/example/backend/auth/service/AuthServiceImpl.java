package com.example.backend.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;
import com.example.backend.auth.entity.UserEntity;
import com.example.backend.auth.mapper.UserMapper;
import com.example.backend.auth.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
	public SignUpResponseDTO signUpUser(SignUpReqDto signUpReqDto) {

        UserEntity userEntity = userMapper.toEntity(signUpReqDto, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDto(userEntity, SignUpResponseDTO.class);
    
	}
}

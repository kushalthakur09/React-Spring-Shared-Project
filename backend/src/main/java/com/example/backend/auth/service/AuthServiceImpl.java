package com.example.backend.auth.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.auth.dto.LoginReqDto;
import com.example.backend.auth.dto.LoginResponseDto;
import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;
import com.example.backend.auth.entity.RoleEntity;
import com.example.backend.auth.entity.UserEntity;
import com.example.backend.auth.mapper.UserMapper;
import com.example.backend.auth.repository.RoleRepository;
import com.example.backend.auth.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    @Override
	public SignUpResponseDTO signUpUser(SignUpReqDto signUpReqDto) {
    	RoleEntity role = roleRepository.findByName(signUpReqDto.getRole());

        UserEntity userEntity= UserEntity.builder()
                .email(signUpReqDto.getEmail())
                .username(signUpReqDto.getUsername())
                .password(signUpReqDto.getPassword())
                .roleEntity(role)
                .createdDate(LocalDateTime.now())
                .build();

        userEntity = userRepository.save(userEntity);
        return userMapper.toDto(userEntity, SignUpResponseDTO.class);
    
	}
    public LoginResponseDto loginUser(LoginReqDto loginReqDto) {
    	UserEntity user = userRepository.findByEmail(loginReqDto.getEmail());
    	LoginResponseDto loginResponseDto = userMapper.toDto(user, LoginResponseDto.class);
    	return loginResponseDto;
    }
}

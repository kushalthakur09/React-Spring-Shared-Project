package com.example.backend.auth.service;

import com.example.backend.auth.dto.LoginReqDto;
import com.example.backend.auth.dto.LoginResponseDto;
import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;
import com.example.backend.auth.entity.UserEntity;

public interface AuthService  {
	SignUpResponseDTO signUpUser(SignUpReqDto signUpReqDto);

	UserEntity findByUsername(String username);

}

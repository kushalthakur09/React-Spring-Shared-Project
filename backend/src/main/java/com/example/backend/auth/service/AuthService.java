package com.example.backend.auth.service;

import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;

public interface AuthService  {
	SignUpResponseDTO signUpUser(SignUpReqDto signUpReqDto);

}

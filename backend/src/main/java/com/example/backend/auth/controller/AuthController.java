package com.example.backend.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;
import com.example.backend.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping(value = "/signup")
	public ResponseEntity<SignUpResponseDTO> signUpUser(@RequestBody SignUpReqDto signUpReqDto) {
	    SignUpResponseDTO userDtoRes = authService.signUpUser(signUpReqDto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(userDtoRes);
	}
}

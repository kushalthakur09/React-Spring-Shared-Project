package com.example.backend.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.auth.dto.LoginReqDto;
import com.example.backend.auth.dto.LoginResponseDto;
import com.example.backend.auth.dto.SignUpReqDto;
import com.example.backend.auth.dto.SignUpResponseDTO;
import com.example.backend.auth.entity.UserEntity;
import com.example.backend.auth.security.JwtTokenUtil;
import com.example.backend.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/signup")
	public ResponseEntity<SignUpResponseDTO> signUpUser(@RequestBody SignUpReqDto signUpReqDto) {
		SignUpResponseDTO userDtoRes = authService.signUpUser(signUpReqDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDtoRes);
	}

	@PostMapping(value = "/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody LoginReqDto loginReqDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword()));

		if (authentication.isAuthenticated()) {

			// Generate token
			String token = jwtTokenUtil.generateToken(loginReqDto.getUsername());

			// Fetch user details
			UserEntity userEntity = authService.findByUsername(loginReqDto.getUsername());

			// Prepare response
			LoginResponseDto response = new LoginResponseDto(userEntity.getId(), userEntity.getUsername(),
					userEntity.getEmail(), userEntity.getRoleEntity().getName(), token);

			return ResponseEntity.ok(response);
		}

		// Failure response (JSON)
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Login Failed\"}");
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, your JWT is valid!";
	}
}

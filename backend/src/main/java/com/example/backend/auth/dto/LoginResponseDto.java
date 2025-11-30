package com.example.backend.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private Long id;
    private String username;
    private String email;
    private String role;
    private String token; // optional: store JWT here
}

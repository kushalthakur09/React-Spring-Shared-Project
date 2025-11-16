package com.example.backend.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupDto {
@NotNull(message = "username is required")
@Size(min=3, max=15, message="Username should be atleast 3 characters and max 15 characters")
private String username;
@NotNull(message = "password is required")
@Size(min=3, max=15, message="Password should be atleast 3 characters and max 15 characters")
private String password;
@NotNull(message = "Email is required")
@Email(message ="Enter Valid Email Address")
private String email;
}

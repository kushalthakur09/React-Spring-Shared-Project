package com.example.backend.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpReqDto {
		@JsonProperty
     private String username;
		@JsonProperty
     private String password;
		@JsonProperty
     private String email;
}

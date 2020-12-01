package com.example.authms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class RegisterRequest {
    String username;
    String password;
    String confirmedPassword;
}

package com.example.authms.controller;


import com.example.authms.dto.RegisterRequest;
import com.example.authms.model.Enseignant;
import com.example.authms.model.User;
import com.example.authms.repository.UserRepository;
import com.example.authms.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class AuthController {
    private  UserRepository userRepository;
    private final AuthService authService;
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest) {
        return authService.saveUser(registerRequest);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
//        System.out.println("eze"+userRepository.findAll());
        return status(HttpStatus.OK).body(userRepository.findAll());
    }

}

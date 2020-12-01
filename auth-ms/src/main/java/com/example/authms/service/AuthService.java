package com.example.authms.service;

import com.example.authms.dto.RegisterRequest;
import com.example.authms.model.Role;
import com.example.authms.model.User;

public interface AuthService {
    public User saveUser(RegisterRequest registerRequest);
    public Role save(Role role);
    public User loadUserByUsername(String Username);
    public void addRoleToUser(String username, String roleName);
}

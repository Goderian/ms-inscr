package com.example.authms.service;

import com.example.authms.dto.RegisterRequest;
import com.example.authms.model.Role;
import com.example.authms.model.User;
import com.example.authms.repository.RoleRepository;
import com.example.authms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    /*
    * Verify that the user does not already exist in DB
    * and adds him
    * */
    @Override
    public User saveUser(RegisterRequest registerRequest) {
        User user = userRepository.findByUsername(registerRequest.getUsername());
        if (user != null) throw new RuntimeException("user already exists");
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmedPassword())) throw new RuntimeException("Please confirm your password!");
        User user1 = new User();
        user1.setUsername(registerRequest.getUsername());
        user1.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));;
        user1.setActivated(true);
        userRepository.save(user1);
        addRoleToUser(registerRequest.getUsername(), "USER");
        return user1;
    }
    /*
    * Adding roles to DB
    * */
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    /*finding user by user name
    * */
    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    /*adding roles to a user
    * */
    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }
}

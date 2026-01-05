package com.college.eventportal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.eventportal.config.JwtUtil;
import com.college.eventportal.dto.*;
import com.college.eventportal.entity.User;
import com.college.eventportal.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwt;

    public void register(RegisterRequest r) {
        User u = new User();
        u.setName(r.getName());
        u.setEmail(r.getEmail());
        u.setPassword(encoder.encode(r.getPassword()));
        u.setRole(r.getRole() == null ? "ROLE_USER" : r.getRole());
        repo.save(u);
    }

    public String login(LoginRequest r) {
        User u = repo.findByEmail(r.getEmail()).orElseThrow();
        if (!encoder.matches(r.getPassword(), u.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwt.generateToken(u.getEmail(), u.getRole());
    }
}

package com.college.eventportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.college.eventportal.dto.*;
import com.college.eventportal.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest r) {
        service.register(r);
        return "Registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest r) {
        return service.login(r);
    }
}

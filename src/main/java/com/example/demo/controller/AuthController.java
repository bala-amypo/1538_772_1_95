package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        User user = new User(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                null
        );

        User savedUser = userService.register(user);

        String token = jwtTokenProvider.generateToken(
                null,
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole()
        );

        return new AuthResponse(token, savedUser.getEmail(), savedUser.getRole());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userService.findByEmail(request.getEmail());

        String token = jwtTokenProvider.generateToken(
                authentication,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new AuthResponse(token, user.getEmail(), user.getRole());
    }
}

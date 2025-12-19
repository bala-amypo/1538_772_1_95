package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


private final AuthenticationManager authenticationManager;
private final JwtTokenProvider jwtTokenProvider;
private final UserService userService;


public AuthController(AuthenticationManager authenticationManager,
JwtTokenProvider jwtTokenProvider,
UserService userService) {
this.authenticationManager = authenticationManager;
this.jwtTokenProvider = jwtTokenProvider;
this.userService = userService;
}


@PostMapping("/register")
public AuthResponse register(@RequestBody RegisterRequest request) {
User user = new User(null, request.getName(), request.getEmail(), request.getPassword(), null);
User saved = userService.register(user);
return new AuthResponse(null, saved.getId(), saved.getEmail(), saved.getRole());
}


@PostMapping("/login")
public AuthResponse login(@RequestBody LoginRequest request) {
Authentication authentication = authenticationManager.authenticate(
new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));


User user = userService.findByEmail(request.getEmail());
String token = jwtTokenProvider.generateToken(authentication, user.getId(), user.getEmail(), user.getRole());


return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
}
}
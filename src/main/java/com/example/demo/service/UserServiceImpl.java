package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ConflictException("Username already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ConflictException("User not found"));
    }

    @Override
    public User getById(Long id) {   // ✅ REQUIRED
        return userRepository.findById(id)
                .orElseThrow(() -> new ConflictException("User not found"));
    }
}

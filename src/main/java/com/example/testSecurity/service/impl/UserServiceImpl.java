package com.example.testSecurity.service.impl;

import com.example.testSecurity.model.User;
import com.example.testSecurity.repository.UserRepository;
import com.example.testSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}

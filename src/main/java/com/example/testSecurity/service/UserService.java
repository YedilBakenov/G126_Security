package com.example.testSecurity.service;

import com.example.testSecurity.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserByEmail(String email);
}

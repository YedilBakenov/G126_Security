package com.example.testSecurity.service.impl;

import com.example.testSecurity.model.User;
import com.example.testSecurity.repository.PermissionRepository;
import com.example.testSecurity.repository.UserRepository;
import com.example.testSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User)authentication.getPrincipal();
    }

    @Override
    public void addUser(User user, String rePassword) {
        User userInBase = findUserByEmail(user.getEmail());

        if(userInBase!=null){
            return;
        }

        if(!user.getPassword().equals(rePassword)){
            return;
        }

        user.setPermissions(List.of(permissionRepository.userPermission()));

        user.setPassword(encoder.encode(rePassword));

        userRepository.save(user);

    }

    @Override
    public void changePassword(String password, String newPassword, String reNewPassword) {
        if(!encoder.matches(password, getCurrentUser().getPassword())){
            return;
        }

        if(!newPassword.equals(reNewPassword)){
            return;
        }

        if(encoder.matches(newPassword, getCurrentUser().getPassword())){
            return;
        }

        getCurrentUser().setPassword(encoder.encode(newPassword));

        userRepository.save(getCurrentUser());


    }
}

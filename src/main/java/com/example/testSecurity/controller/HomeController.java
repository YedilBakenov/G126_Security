package com.example.testSecurity.controller;

import com.example.testSecurity.model.User;
import com.example.testSecurity.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserServiceImpl userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/")
    public String homePage(){
        System.out.println(userService.getCurrentUser());
        return "main";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in")
    public String loginPage(){
        return "login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin")
    public String adminPage(){
        return "admin-page";
    }

    @GetMapping(value = "/forbidden")
    public String forbiddenPage(){
        return "forbidden";
    }

    @GetMapping(value = "/register")
    public String register(){
        return "register-page";
    }


    @PostMapping(value = "/register-user")
    public String registerPage(User user,
                               @RequestParam String rePassword){

        userService.addUser(user, rePassword);

        return "login";
    }

    @PostMapping(value = "/change-pas")
    public String changePas(@RequestParam String password,
                            @RequestParam String newPassword,
                            @RequestParam String reNewPassword){

        userService.changePassword(password, newPassword, reNewPassword);

        return "main";
    }
}

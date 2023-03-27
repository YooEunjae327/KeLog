package com.temp.kelog.domain.user.controller;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.service.UserService;
import com.temp.kelog.global.annotations.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterDto request) {
        userService.register(request);
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginDto request) {
         return userService.login(request);
    }

    @AuthToken
    @PostMapping("/{email}")
    public void UserProfile() {
        System.out.println("text");
        // System.out.println(user);
        // userService.UserProfile(email);
    }

}

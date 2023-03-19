package com.temp.kelog.domain.user.controller;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void login(@RequestBody @Valid LoginDto request) {
         userService.login(request);
    }

}

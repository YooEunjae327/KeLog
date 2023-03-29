package com.temp.kelog.domain.user.controller;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.request.SettingDto;
import com.temp.kelog.domain.user.dto.response.InfoResponse;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.service.UserService;
import com.temp.kelog.global.annotations.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterDto request) {
        userService.register(request);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginDto request) {
         return userService.login(request);
    }

    @PostMapping("/@{username}")
    @ResponseStatus(HttpStatus.OK)
    public InfoResponse userProfile(@RequestAttribute User user ) {
        return userService.userProfile(user);
    }

    @AuthToken
    @PutMapping("/setting")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserProfile(@RequestAttribute User user, SettingDto request) {
        userService.updateUserProfile(user, request);
    }

}

package com.temp.kelog.domain.user.controller;

import com.temp.kelog.domain.user.dto.request.RegisterDTO;
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
    public void register(@RequestBody @Valid RegisterDTO request) {
        userService.register(request);
    }
    //public class register() {}

}

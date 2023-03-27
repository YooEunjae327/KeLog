package com.temp.kelog.domain.kelog.controller;

import com.temp.kelog.domain.kelog.service.KelogService;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.global.annotations.AuthToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/kelog")
@RequiredArgsConstructor
@Slf4j
public class KelogController {

    private final KelogService kelogService;

    private final UserRepository userRepository;

    @AuthToken
    @GetMapping("test")
    public void test(@RequestAttribute User user) {
        System.out.println(user.getEmail());
    }

    @GetMapping()
    public void allList() {
        kelogService.allList();
    }

//    @AuthToken
//    @PostMapping()
}

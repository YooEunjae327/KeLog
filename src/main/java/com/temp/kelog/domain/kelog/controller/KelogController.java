package com.temp.kelog.domain.kelog.controller;

import com.temp.kelog.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kelog")
@RequiredArgsConstructor
@Slf4j
public class KelogController {


    @GetMapping("test")
    public void test() {
        log.info("truest");
        throw new User.ForbiddenException();
    }
}

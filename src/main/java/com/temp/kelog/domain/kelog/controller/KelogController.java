package com.temp.kelog.domain.kelog.controller;

import com.temp.kelog.global.annotations.AuthToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kelog")
@RequiredArgsConstructor
@Slf4j
public class KelogController {


    @AuthToken
    @GetMapping("test")
    public void test(@RequestHeader HttpHeaders headers ) {
    }
}

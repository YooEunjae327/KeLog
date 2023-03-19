package com.temp.kelog.domain.kelog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kelog")
@RequiredArgsConstructor
public class KelogController {

    @GetMapping("test")
    public void test() {
    }
}

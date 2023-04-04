package com.temp.kelog.domain.kelog.controller;

import com.temp.kelog.domain.kelog.dto.request.CreateDto;
import com.temp.kelog.domain.kelog.service.KelogService;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.global.annotations.AuthToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/kelog")
@RequiredArgsConstructor
@Slf4j
public class KelogController {

    private final KelogService kelogService;

    @AuthToken
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void writeKelog(@RequestPart("file") List<MultipartFile> multipartFile, @RequestAttribute User user, @RequestPart("json") CreateDto request) {
        kelogService.writeKelog(multipartFile, user, request);
    }

    @GetMapping()
    public void allList() {
        kelogService.allList();
    }

}

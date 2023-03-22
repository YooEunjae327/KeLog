package com.temp.kelog.domain.s3.controller;

import com.temp.kelog.domain.s3.service.S3Service;
import com.temp.kelog.domain.s3.util.MultipartUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;


    @PostMapping()
    public void post(@RequestPart("file")MultipartFile multipartFile) {
        System.out.println(MultipartUtil.getLocalHomeDirectory());
        //s3Service.post(multipartFile);
    }
}

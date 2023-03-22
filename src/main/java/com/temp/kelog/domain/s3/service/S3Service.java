package com.temp.kelog.domain.s3.service;

import com.temp.kelog.domain.s3.dto.S3Dto;
import com.temp.kelog.domain.s3.service.Storage.AmazonS3ResourceStorage;
import com.temp.kelog.domain.s3.util.MultipartUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3ResourceStorage amazonS3ResourceStorage;

    public void post(MultipartFile multipartFile) {
        S3Dto s3Dto = S3Dto.multipartOf(multipartFile);
        amazonS3ResourceStorage.store(s3Dto.getPath(), multipartFile);
    }
}

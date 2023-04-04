package com.temp.kelog.domain.kelog.service;

import com.temp.kelog.domain.kelog.dto.request.CreateDto;
import com.temp.kelog.domain.kelog.entity.Kelog;
import com.temp.kelog.domain.kelog.repository.KelogRepository;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.global.dto.S3Dto;
import com.temp.kelog.global.s3.AmazonS3ResourceStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class KelogService {

    private final KelogRepository kelogRepository;

    private final AmazonS3ResourceStorage amazonS3ResourceStorage;

    public void writeKelog(List<MultipartFile> multipartFile, User user, CreateDto request) {
        S3Dto s3Dto = S3Dto.multipartOf(multipartFile.get(1));

        System.out.println(s3Dto.toString());
        s3Update(multipartFile);
//
//        Kelog kelog = Kelog.builder()
//                .title(request.getTitle())
//                .image()
//                .content(request.getContent())
//                .user(user)
//                .build();
//
    }

    public void allList() {
        kelogRepository.findAll();
    }


    private void s3Update(List<MultipartFile> multipartFiles) {
        S3Dto s3Dto;
        for (MultipartFile file : multipartFiles) {
            s3Dto = S3Dto.multipartOf(file);
            amazonS3ResourceStorage.store(s3Dto.getPath(), file);
        }
    }

}

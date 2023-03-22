package com.temp.kelog.domain.kelog.service;

import com.temp.kelog.domain.kelog.repository.KelogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class KelogService {

    private final KelogRepository kelogRepository;

    public void allList() {
        kelogRepository.findAll();
    }
}

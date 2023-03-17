package com.temp.kelog.domain.user.service;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.global.exception.CustomException;
import com.temp.kelog.global.exception.ExceptionType;
import com.temp.kelog.global.utils.BCryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void register(RegisterDto request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(ExceptionType.EMAIL_DUPLICATED);
        }



        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(user);
    }

    public void login(LoginDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));



//        if(! passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new CustomException(ExceptionType.INVALID_PARAMETER);
//        }


    }
}

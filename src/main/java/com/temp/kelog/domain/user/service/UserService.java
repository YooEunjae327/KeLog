package com.temp.kelog.domain.user.service;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.LoginResponce;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepositroy;
import com.temp.kelog.global.exception.CustomException;
//import com.temp.kelog.global.exception.ExceptionType;
import com.temp.kelog.global.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepositroy userRepositroy;

    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDto request) {

        if(userRepositroy.findByEmail(request.getEmail())) {
            throw new CustomException(ExceptionType.EMAIL_DUPLICATED);
        }

        //String encodedPassword = passwordEncoder.encode(request.getPassword());
        String encodedPassword = passwordEncoder.encode(request.getPassword());


        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encodedPassword)
                .build();

        userRepositroy.save(user);
    }

    public LoginResponce login(LoginDto request) {

        User user = userRepositroy.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));



        if(! passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException(ExceptionType.INVALID_PARAMETER);
        }



    }
}

package com.temp.kelog.domain.user.service;

import com.ibm.cuda.CudaException;
import com.temp.kelog.domain.user.dto.request.RegisterDTO;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepositroy;
import com.temp.kelog.global.configuration.BcryptConfig;
import com.temp.kelog.global.exception.CustomException;
//import com.temp.kelog.global.exception.ExceptionType;
import com.temp.kelog.global.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepositroy userRepositroy;

    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDTO request) {

        if(userRepositroy.findByEmail(request.getEmail())) {
            throw new CustomException(ExceptionType.EMAIL_DUPLICATED);
        }

        //String encodedPassword = passwordEncoder.encode(request.getPassword());
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        System.out.println(request);

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encodedPassword)
                .build();

        // userRepositroy.save(user);
    }
}

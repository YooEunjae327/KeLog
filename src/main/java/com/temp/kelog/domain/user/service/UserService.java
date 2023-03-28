package com.temp.kelog.domain.user.service;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.global.enums.JwtAuth;
import com.temp.kelog.global.exception.CustomException;
import com.temp.kelog.global.exception.ExceptionType;
import com.temp.kelog.global.jwt.TokenProvider;
import com.temp.kelog.global.utils.BCryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;



    public void register(RegisterDto request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new User.AlreadyExistedException();
        }



        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

         userRepository.save(user);
    }

    public LoginResponse login(LoginDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(User.NotFoundException::new);


        if(! BCryptUtils.isMatch(request.getPassword(), user.getPassword())) {
            throw new User.NotFountPasswordException();
        }

        String accessToken = tokenProvider.generateToken(user.getEmail(), JwtAuth.ACCESS_TOKEN);
        String refreshToken = tokenProvider.generateToken(user.getEmail(), JwtAuth.REFRESH_TOKEN);

        return new LoginResponse(accessToken,refreshToken);
    }

    public void UserProfile(User user,String request) {

    }
}

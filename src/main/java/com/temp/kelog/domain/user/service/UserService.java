package com.temp.kelog.domain.user.service;

import com.temp.kelog.domain.user.dto.request.LoginDto;
import com.temp.kelog.domain.user.dto.request.RegisterDto;
import com.temp.kelog.domain.user.dto.response.InfoResponse;
import com.temp.kelog.domain.user.dto.response.LoginResponse;
import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.entity.UserSocialInfo;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.domain.user.repository.UserSocialInfoRepository;
import com.temp.kelog.global.enums.JwtAuth;
import com.temp.kelog.global.jwt.TokenProvider;
import com.temp.kelog.global.utils.BCryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserSocialInfoRepository userSocialInfoRepository;
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
                .userSocialInfo(createSocialInfo())
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

    public InfoResponse userProfile(User user) {


//
//        User user = userRepository.findByUsername(request)
//                .orElseThrow(User.NotFoundException::new);


        return InfoResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .introduction(user.getIntroduction())
                .build();
    }

    public void updateUserProfile(User user) {
    }

    public UserSocialInfo createSocialInfo() {
        UserSocialInfo userSocialInfo = new UserSocialInfo();
        userSocialInfoRepository.save(userSocialInfo);

        return userSocialInfo;
    }
}

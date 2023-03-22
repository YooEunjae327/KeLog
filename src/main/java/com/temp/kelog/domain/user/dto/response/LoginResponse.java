package com.temp.kelog.domain.user.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
}

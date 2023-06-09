package com.temp.kelog.domain.user.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponse {

    @NotBlank
    private String accessToken;

    @NotBlank
    private String refreshToken;
}

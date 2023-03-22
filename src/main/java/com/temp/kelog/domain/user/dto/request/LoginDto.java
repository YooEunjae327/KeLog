package com.temp.kelog.domain.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginDto {

    @NotBlank()
    private String email;

    @NotBlank()
    private String password;
}

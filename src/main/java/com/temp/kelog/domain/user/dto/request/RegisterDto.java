package com.temp.kelog.domain.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RegisterDto {

    @NotBlank()
    private String username;

    @NotBlank()
    private String email;

    @NotBlank()
    private String password;

}

package com.temp.kelog.domain.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RegisterDTO {

    @NotBlank()
    private String userName;

    @NotBlank()
    private String email;

    @NotBlank()
    private String password;

}

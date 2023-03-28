package com.temp.kelog.domain.user.dto.response;

import com.temp.kelog.domain.user.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class InfoResponse {

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String introduction;

}

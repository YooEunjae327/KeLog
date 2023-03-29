package com.temp.kelog.domain.user.dto.request;

import com.temp.kelog.domain.user.entity.UserSocialInfo;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SettingDto {

    private String introduction;
    private String interest;
    private String github;
    private String twitter;
    private String facebook;
    private String homepage;

    public UserSocialInfo toSocialInfo() {
        return UserSocialInfo.builder()
                .github(github)
                .twitter(twitter)
                .facebook(facebook)
                .homepage(homepage)
                .build();
    }

}

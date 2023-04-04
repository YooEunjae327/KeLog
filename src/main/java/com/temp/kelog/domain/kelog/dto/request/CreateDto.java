package com.temp.kelog.domain.kelog.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreateDto {

    private String title;
    private String content;
}

package com.temp.kelog.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "usersocialinfo")
public class UserSocialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String github;

    private String twitter;

    private String facebook;

    private String homepage;

}

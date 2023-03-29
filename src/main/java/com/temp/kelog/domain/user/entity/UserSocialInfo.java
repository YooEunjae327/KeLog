package com.temp.kelog.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PUBLIC)
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

    public void updateAll(String github, String twitter, String facebook,
                          String homepage) {
        this.github = github;
        this.twitter = twitter;
        this.facebook = facebook;
        this.homepage = homepage;
    }

}

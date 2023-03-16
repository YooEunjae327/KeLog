package com.temp.kelog.domain.token.entity;

import com.temp.kelog.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id", nullable = false)
    private Long id;

    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Token(String refreshToken, User user) {
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public void refreshUpdate(String refreshToken) {
         this.refreshToken = refreshToken;
    }
}

package com.temp.kelog.domain.user.entity;

import com.temp.kelog.domain.kelog.entity.Kelog;
import com.temp.kelog.global.exception.BusinessException;
import com.temp.kelog.global.utils.BCryptUtils;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "user_email", unique = true)
    @Size(max = 50)
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_profile_img")
    private String image;

    @Column(name = "user_profile_introduction")
    private String introduction;

    @Column(name = "user_profile_interest")
    private String interest;

    @OneToMany(mappedBy = "user")
    private List<Kelog> kelog = new ArrayList<Kelog>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_social_info", referencedColumnName = "id")
    private UserSocialInfo userSocialInfo;

    @Builder
    public User(String username, String email, String password, UserSocialInfo userSocialInfo) {
        this.username = username;
        this.email = email;
        this.password = BCryptUtils.encrypt(password);
        this.userSocialInfo = userSocialInfo;
    }

    public void changeUserProfile(String introduction, String interest) {
        this.introduction = introduction;
        this.interest = interest;
    }

    public void updateSocialInfo(UserSocialInfo socialInfo) {
        this.userSocialInfo.updateAll(
                socialInfo.getGithub(), socialInfo.getTwitter(),
                socialInfo.getFacebook(), socialInfo.getHomepage()
        );
    }

    public static class NotFountPasswordException extends BusinessException {
        public NotFountPasswordException() { super(HttpStatus.NOT_FOUND, "비밀번호가 다릅니다.");}
    }

    public static class NotFoundException extends BusinessException {
        public NotFoundException() {
            super(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다.");
        }
    }

    public static class UnAuthenticationException extends BusinessException {
        public UnAuthenticationException() {
            super(HttpStatus.UNAUTHORIZED, "토큰이 입력되지 않았습니다.");
        }
    }

    public static class ForbiddenException extends BusinessException {
        public ForbiddenException() {
            super(HttpStatus.FORBIDDEN, "접근할 수 있는 권한이 없습니다.");
        }
    }

    public static class AlreadyExistedException extends BusinessException {
        public AlreadyExistedException() {
            super(HttpStatus.CONFLICT, "이미 가입된 회원입니다.");
        }
    }

}

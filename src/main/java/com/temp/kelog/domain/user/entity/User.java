package com.temp.kelog.domain.user.entity;

import com.temp.kelog.domain.kelog.entity.Kelog;
import com.temp.kelog.global.utils.BCryptUtils;
import lombok.*;

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

    @Column(name = "user_name")
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

    @Builder
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = BCryptUtils.encrypt(password);
    }

}

package com.temp.kelog.domain.kelog.entity;

import com.temp.kelog.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@ToString
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Table(name = "kelog")
public class Kelog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kelog_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Size(max = 30)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = true)
    @Size(max = 5000)
    private String  content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

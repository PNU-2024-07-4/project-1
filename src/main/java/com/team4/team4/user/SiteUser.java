package com.team4.team4.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String contactNumber;  // 연락처

    @Column(length = 255)
    private String profilePicture;

    @Column(length = 200)
    private String bio;

    private String socialMediaHandles;  // SNS 계정
}
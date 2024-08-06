package com.team4.team4.user;

import com.team4.team4.board.Board;
import com.team4.team4.participation.Participation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    @OneToMany(mappedBy = "participant")
    private List<Participation> participations;
}
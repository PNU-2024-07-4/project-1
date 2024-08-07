package com.team4.team4.board;

import com.team4.team4.comment.Comment;
import com.team4.team4.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private SiteUser user;

  @Column(nullable = false, length = 50)
  private String subject;

  @Column(nullable = false, length = 255)
  private String content;

  @Column(nullable = false)
  private LocalDate startDay;

  @Column(nullable = false)
  private LocalDate endDay;

  @Column(nullable = false, length = 50)
  private String region;

  @Column(nullable = false)
  private int recruitNumber;

  private int currentNumber;

  @Column(length = 50)
  private String recommendedTo;

  @OneToMany(mappedBy = "board")
  private List<Comment> comments;

}

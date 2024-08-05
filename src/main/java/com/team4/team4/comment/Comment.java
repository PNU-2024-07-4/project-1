package com.team4.team4.comment;

import com.team4.team4.board.Board;
import com.team4.team4.user.SiteUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private SiteUser user;

  @ManyToOne
  @JoinColumn(name = "boardId", nullable = false)
  private Board board;

  @Column(nullable = false, length = 255)
  private String content;

  @Column(nullable = false)
  private LocalDateTime createdAt;

}
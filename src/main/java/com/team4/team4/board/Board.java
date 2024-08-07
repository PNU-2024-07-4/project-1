package com.team4.team4.board;

import com.team4.team4.comment.Comment;
import com.team4.team4.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
  private LocalDateTime startDay;

  @Column(nullable = false)
  private LocalDateTime endDay;

  @Column(nullable = false, length = 50)
  private String region;

  @Column(nullable = false)
  private int recruitNumber;

  private int currentNumber;

  @Column(length = 50)
  private String recommendedTo;

  @OneToMany(mappedBy = "board")
  private List<Comment> comments;

  public String getFormattedStartDay() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    return startDay.format(formatter);
  }

  public String getFormattedEndDay() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    return endDay.format(formatter);
  }
}

package com.team4.team4.participation;

import com.team4.team4.board.Board;
import com.team4.team4.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Participation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "boardId", nullable = false)
  private Board board;

  @ManyToOne
  @JoinColumn(name = "participantId", nullable = false)
  private SiteUser participant;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private ParticipationStatus status;

  public enum ParticipationStatus {
    PENDING, APPROVED, REJECTED
  }

  @Column(nullable = false)
  private LocalDateTime requestDate;

  @Column
  private LocalDateTime responseDate;

  public String getStatusDisplay() {
    switch (this.status) {
      case PENDING:
        return "수락 대기중";
      case APPROVED:
        return "수락됨";
      case REJECTED:
        return "거절됨";
      default:
        return "알 수 없음";
    }
  }


}
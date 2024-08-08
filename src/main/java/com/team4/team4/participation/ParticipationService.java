package com.team4.team4.participation;

import com.team4.team4.DataNotFoundException;
import com.team4.team4.board.Board;
import com.team4.team4.board.BoardService;
import com.team4.team4.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ParticipationService {
  private final ParticipationRepository participationRepository;
  private final BoardService boardService;

  public Participation createParticipation(Long boardId, SiteUser participant) {
    Board board = boardService.getBoard(boardId);

    Participation participation = new Participation();
    participation.setBoard(board);
    participation.setParticipant(participant);
    participation.setStatus(Participation.ParticipationStatus.PENDING);
    participation.setRequestDate(LocalDateTime.now());

    return participationRepository.save(participation);
  }

  public Participation getParticipation(Long id) {
    Optional<Participation> participation = this.participationRepository.findById(id);
    if (participation.isPresent()) {
      return participation.get();
    } else {
      throw new DataNotFoundException("Participation not found");
    }
  }

  public void acceptParticipation(Long participationId) {
    Participation participation = getParticipation(participationId);
    Board board = participation.getBoard();
    participation.setStatus(Participation.ParticipationStatus.APPROVED);
    participation.setResponseDate(LocalDateTime.now());
    participationRepository.save(participation);
    board.setCurrentNumber(board.getCurrentNumber() + 1);
    boardService.save(board);  // Add save method in BoardService if not exists
  }

  public void rejectParticipation(Long participationId) {
    Participation participation = getParticipation(participationId);
    if (participation.getStatus() == Participation.ParticipationStatus.APPROVED) {
      Board board = participation.getBoard();
      board.setCurrentNumber(board.getCurrentNumber() - 1);
      boardService.save(board);  // Add save method in BoardService if not exists
    }
    participation.setStatus(Participation.ParticipationStatus.REJECTED);
    participation.setResponseDate(LocalDateTime.now());
    participationRepository.save(participation);
  }

  public void cancelParticipation(Long participationId) {
    Participation participation = getParticipation(participationId);
    if (participation.getStatus() == Participation.ParticipationStatus.APPROVED) {
      Board board = participation.getBoard();
      board.setCurrentNumber(board.getCurrentNumber() - 1);
      boardService.save(board);  // Add save method in BoardService if not exists
    }
    participationRepository.delete(participation);
  }

  public int countApprovedParticipations(Long boardId) {
    return (int) participationRepository.findByBoard_Id(boardId)
        .stream()
        .filter(participation -> participation.getStatus() == Participation.ParticipationStatus.APPROVED)
        .count();
  }
}

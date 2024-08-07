package com.team4.team4.participation;

import com.team4.team4.board.Board;
import com.team4.team4.board.BoardRepository;
import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    // 참여 신청 생성 및 저장
    public Participation createParticipation(Long boardId, SiteUser participant) {
        Optional<Board> boardOptional = boardRepository.findById(boardId);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Participation participation = new Participation();
            participation.setBoard(board);
            participation.setParticipant(participant);
            participation.setRequestDate(LocalDateTime.now());
            participation.setStatus(Participation.ParticipationStatus.PENDING);
            return participationRepository.save(participation);
        }
        return null;
    }

    // 전체 참여 신청 목록 조회
    public List<Participation> findAll() {
        return participationRepository.findAll();
    }

    // 특정 참여 신청 조회
    public Optional<Participation> findById(Long id) {
        return participationRepository.findById(id);
    }

    // 참여 신청 생성 및 저장
    public Participation save(Participation participation) {
        if (participation.getId() == null) {
            participation.setRequestDate(LocalDateTime.now());
            participation.setStatus(Participation.ParticipationStatus.PENDING);
        }
        return participationRepository.save(participation);
    }

    // 참여 신청 삭제
    public void deleteById(Long id) {
        participationRepository.deleteById(id);
    }

    // 특정 게시글의 참여 신청 목록 조회
    public List<Participation> findByBoardId(Long boardId) {
        return participationRepository.findByBoard_Id(boardId);
    }

    // 특정 사용자의 참여 신청 목록 조회
    public List<Participation> findByParticipantId(Long participantId) {
        return participationRepository.findByParticipant_Id(participantId);
    }

    // 참여 신청 승인
    public Participation approveParticipation(Long id) {
        Optional<Participation> participationOptional = participationRepository.findById(id);
        if (participationOptional.isPresent()) {
            Participation participation = participationOptional.get();
            participation.setStatus(Participation.ParticipationStatus.APPROVED);
            participation.setResponseDate(LocalDateTime.now());
            return participationRepository.save(participation);
        }
        return null;
    }

    // 참여 신청 거절
    public Participation rejectParticipation(Long id) {
        Optional<Participation> participationOptional = participationRepository.findById(id);
        if (participationOptional.isPresent()) {
            Participation participation = participationOptional.get();
            participation.setStatus(Participation.ParticipationStatus.REJECTED);
            participation.setResponseDate(LocalDateTime.now());
            return participationRepository.save(participation);
        }
        return null;
    }
}
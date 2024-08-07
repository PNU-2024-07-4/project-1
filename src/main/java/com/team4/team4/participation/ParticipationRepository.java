package com.team4.team4.participation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
  List<Participation> findByBoard_Id(Long boardId); //특정 Board 게시글에 대한 모든 참여 신청을 반환
  List<Participation> findByParticipant_Id(Long participantId); //특정 사용자(SiteUser)가 참여한 모든 게시글 참여 신청을 반환
}
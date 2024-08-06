package com.team4.team4.participation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participations")
public class ParticipationController {
    @Autowired
    private ParticipationService participationService;

    // 전체 참여 목록 조회 (GET /participations)
    @GetMapping
    public List<Participation> getAllParticipations() {
        return participationService.findAll();
    }

    // 특정 참여 조회 (GET /participations/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Participation> getParticipationById(@PathVariable Long id) {
        Optional<Participation> participation = participationService.findById(id);
        return participation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 참여 신청 생성 (POST /participations)
    @PostMapping
    public Participation createParticipation(@RequestBody Participation participation) {
        return participationService.save(participation);
    }

    // 참여 신청 승인 (PUT /participations/{id}/approve)
    @PutMapping("/{id}/approve")
    public ResponseEntity<Participation> approveParticipation(@PathVariable Long id) {
        Participation participation = participationService.approveParticipation(id);
        if (participation != null) {
            return ResponseEntity.ok(participation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 참여 신청 거절 (PUT /participations/{id}/reject)
    @PutMapping("/{id}/reject")
    public ResponseEntity<Participation> rejectParticipation(@PathVariable Long id) {
        Participation participation = participationService.rejectParticipation(id);
        if (participation != null) {
            return ResponseEntity.ok(participation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 참여 신청 삭제 (DELETE /participations/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipation(@PathVariable Long id) {
        if (participationService.findById(id).isPresent()) {
            participationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
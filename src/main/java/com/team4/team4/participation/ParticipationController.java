package com.team4.team4.participation;

import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participations")
public class ParticipationController {
    @Autowired
    private ParticipationService participationService;

    @Autowired
    private UserService userService;

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
    public String createParticipation(@RequestParam Long boardId, Principal principal) {
        SiteUser user = userService.getUser(principal.getName());
        Participation participation = participationService.createParticipation(boardId, user);
        if (participation != null) {
            return "redirect:/board/detail/" + boardId;
        } else {
            return "error";
        }
    }

    // 참여 신청 승인 (POST /participations/{id}/approve)
    @PostMapping("/{id}/approve")
    public String approveParticipation(@PathVariable Long id) {
        Participation participation = participationService.approveParticipation(id);
        if (participation != null) {
            return "redirect:/board/detail/" + participation.getBoard().getId();
        } else {
            return "error";
        }
    }

    // 참여 신청 거절 (POST /participations/{id}/reject)
    @PostMapping("/{id}/reject")
    public String rejectParticipation(@PathVariable Long id) {
        Participation participation = participationService.rejectParticipation(id);
        if (participation != null) {
            return "redirect:/board/detail/" + participation.getBoard().getId();
        } else {
            return "error";
        }
    }

    // 참여 신청 삭제 (POST /participations/{id})
    @PostMapping("/{id}")
    public String deleteParticipation(@PathVariable Long id) {
        Optional<Participation> participationOptional = participationService.findById(id);
        if (participationOptional.isPresent()) {
            Participation participation = participationOptional.get();
            participationService.deleteById(id);
            return "redirect:/board/detail/" + participation.getBoard().getId();
        } else {
            return "error";
        }
    }
}
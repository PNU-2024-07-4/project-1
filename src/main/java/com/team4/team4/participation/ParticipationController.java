package com.team4.team4.participation;

import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/participations")
@RequiredArgsConstructor
@Controller
public class ParticipationController {

    private final ParticipationService participationService;
    private final UserService userService;

    @PostMapping("/create/{boardId}")
    public String createParticipation(Model model, @PathVariable("boardId") Long boardId, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        SiteUser participant = userService.getUser(principal.getName());
        if (participationService.isAlreadyParticipated(boardId,participant)) {
            model.addAttribute("error", "이미 이 게시글에 신청하셨습니다.");
            // 게시글 상세 페이지로 리다이렉트
            return String.format("redirect:/board/detail/%s", boardId);
        }
        participationService.createParticipation(boardId, participant);
        return String.format("redirect:/board/detail/%s", boardId);
    }

    @PostMapping("/accept/{participationId}")
    public String acceptParticipation(@PathVariable("participationId") Long participationId, Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Participation participation = participationService.getParticipation(participationId);
        try {
            participationService.acceptParticipation(participationId);
            return String.format("redirect:/board/detail/%s", participation.getBoard().getId());
        } catch(RuntimeException e) {
            return String.format("redirect:/board/detail/%s", participation.getBoard().getId());
        }
    }

    @PostMapping("/reject/{participationId}")
    public String rejectParticipation(@PathVariable("participationId") Long participationId, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Participation participation = participationService.getParticipation(participationId);
        participationService.rejectParticipation(participationId);
        return String.format("redirect:/board/detail/%s", participation.getBoard().getId());
    }

    @PostMapping("/cancel/{participationId}")
    public String cancelParticipation(@PathVariable("participationId") Long participationId, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Participation participation = participationService.getParticipation(participationId);
        participationService.cancelParticipation(participationId);
        return String.format("redirect:/board/detail/%s", participation.getBoard().getId());
    }
}
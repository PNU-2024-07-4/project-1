package com.team4.team4.board;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.validation.BindingResult;

import java.security.Principal;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/")
    public String getAllBoards(Model model, @RequestParam(value="page", defaultValue ="0") int page) {
        Page<Board> paging = this.boardService.getAllBoards(page);
        model.addAttribute("paging", paging);
        return "main_board";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String createBoard(BoardForm boardForm) {
        return "board_create_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String createBoard(@Valid BoardForm boardForm, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "board_create_form";
        }
        SiteUser user = this.userService.getUser(principal.getName());

        this.boardService.create(boardForm,user );
        return "redirect:/";
    }


}

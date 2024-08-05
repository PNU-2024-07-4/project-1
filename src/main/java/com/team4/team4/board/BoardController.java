package com.team4.team4.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String getAllBoards(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "main_board";
    }
}

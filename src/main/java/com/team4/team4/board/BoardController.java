package com.team4.team4.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String getAllBoards(Model model, @RequestParam(value="page", defaultValue ="0") int page) {
        Page<Board> paging = this.boardService.getAllBoards(page);
        model.addAttribute("paging", paging);
        return "main_board";
    }

    @GetMapping("/board/create")
    public String createBoard() {
        return "board_create_form";
    }

    @GetMapping("/board/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }

}

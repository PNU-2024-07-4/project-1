package com.team4.team4.board;

import com.team4.team4.DataNotFoundException;
import com.team4.team4.comment.Comment;
import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserRepository;
import com.team4.team4.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board getBoard(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if(board.isPresent()) {
            return board.get();
        }else {
            throw new DataNotFoundException("Board not found");
        }
    }

    public void create (BoardForm boardForm, SiteUser siteUser) {
        System.out.println("service - boardForm: " + boardForm.getRegion() + boardForm.getStartDay());
        List<Comment> comments = new ArrayList<Comment>();

        Board newBoard = new Board();
        newBoard.setContent(boardForm.getContent());
        newBoard.setSubject(boardForm.getSubject());
        newBoard.setUser(siteUser);
        newBoard.setStartDay(boardForm.getStartDay());
        newBoard.setEndDay(boardForm.getEndDay());
        newBoard.setRegion(boardForm.getRegion());
        newBoard.setRecruitNumber(boardForm.getRecruitNumber());
        newBoard.setCurrentNumber(0);
        newBoard.setRecommendedTo(boardForm.getRecommendedTo());
        newBoard.setComments(comments);


        this.boardRepository.save(newBoard);

    }

}

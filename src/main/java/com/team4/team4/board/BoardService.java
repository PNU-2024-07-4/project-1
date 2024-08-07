package com.team4.team4.board;

import com.team4.team4.participation.Participation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.team4.team4.DataNotFoundException;
import com.team4.team4.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    public Page<Board> getAllBoards(int page) {
        Pageable pageable = PageRequest.of(page, 3);
        return this.boardRepository.findAll(pageable);
    }

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
        List<Participation> comments = new ArrayList<Participation>();

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
        newBoard.setParticipations(comments);


        this.boardRepository.save(newBoard);

    }

}

package com.team4.team4.board;

import com.team4.team4.DataNotFoundException;
import com.team4.team4.participation.Participation;
import com.team4.team4.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    public Page<Board> getAllBoards(int page) {
        List<Sort.Order> sites = new ArrayList<>();
        sites.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 3, Sort.by(sites));
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
        newBoard.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(newBoard);
    }

    public void edit(Board board, BoardForm boardForm){
        board.setSubject(boardForm.getSubject());
        board.setContent(boardForm.getContent());
        board.setStartDay(boardForm.getStartDay());
        board.setEndDay(boardForm.getEndDay());
        board.setRegion(boardForm.getRegion());
        board.setRecruitNumber(boardForm.getRecruitNumber());
        board.setRecommendedTo(boardForm.getRecommendedTo());
        this.boardRepository.save(board);
    }

    public void save(Board board) {
        this.boardRepository.save(board);
    }

    public void delete (Board board) {
        this.boardRepository.delete(board);
    }

}

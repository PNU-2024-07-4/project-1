package com.team4.team4;

import com.team4.team4.board.Board;
import com.team4.team4.board.BoardRepository;
import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Team4ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

    @Test
    void contextLoads() {
        // 예시 사용자 생성
        SiteUser user = new SiteUser();
        user.setUsername("user1");
        user.setPassword("123");
        user.setEmail("user1@example.com");
        this.userRepository.save(user);

        // 첫번째 게시판 데이터 생성
        Board b1 = new Board();
        b1.setUser(user);
        b1.setSubject("첫번째 게시판 주제");
        b1.setContent("첫번째 게시판 내용입니다.");
        b1.setStartDay(LocalDateTime.now());
        b1.setEndDay(LocalDateTime.now().plusDays(7));
        b1.setRegion("서울");
        b1.setRecruitNumber(10);
        b1.setCurrentNumber(0);
        b1.setRecommendedTo("학생");
        this.boardRepository.save(b1);

        // 두번째 게시판 데이터 생성
        Board b2 = new Board();
        b2.setUser(user);
        b2.setSubject("두번째 게시판 주제");
        b2.setContent("두번째 게시판 내용입니다.");
        b2.setStartDay(LocalDateTime.now());
        b2.setEndDay(LocalDateTime.now().plusDays(5));
        b2.setRegion("부산");
        b2.setRecruitNumber(20);
        b2.setCurrentNumber(5);
        b2.setRecommendedTo("개발자");
        this.boardRepository.save(b2);

        // 세번째 게시판 데이터 생성
        Board b3 = new Board();
        b3.setUser(user);
        b3.setSubject("세번째 게시판 주제");
        b3.setContent("세번째 게시판 내용입니다.");
        b3.setStartDay(LocalDateTime.now());
        b3.setEndDay(LocalDateTime.now().plusDays(10));
        b3.setRegion("대구");
        b3.setRecruitNumber(15);
        b3.setCurrentNumber(3);
        b3.setRecommendedTo("디자이너");
        this.boardRepository.save(b3);
    }

}

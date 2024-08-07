package com.team4.team4;

import com.team4.team4.board.Board;
import com.team4.team4.board.BoardRepository;
import com.team4.team4.user.SiteUser;
import com.team4.team4.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class Team4ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

    @Test
    void contextLoads() {

        // 예제 사용자 생성
        SiteUser user = new SiteUser();
        user.setUsername("user123");
        user.setPassword("12343");
        user.setEmail("user123@example.com");
        this.userRepository.save(user);

        Random random = new Random();

        // 50개의 예제 데이터 생성
        for (int i = 1; i <= 50; i++) {
            Board board = new Board();
            board.setUser(user);
            board.setSubject("주제 " + i);
            board.setContent("내용 " + i);
            board.setStartDay(LocalDate.now().minusDays(random.nextInt(30)));
            board.setEndDay(LocalDate.now().plusDays(random.nextInt(30)));
            board.setRegion("지역 " + (random.nextInt(5) + 1));
            board.setRecruitNumber(random.nextInt(50) + 1);
            board.setCurrentNumber(random.nextInt(10));
            board.setRecommendedTo("대상 " + (random.nextInt(5) + 1));
            this.boardRepository.save(board);
        }
    }

}

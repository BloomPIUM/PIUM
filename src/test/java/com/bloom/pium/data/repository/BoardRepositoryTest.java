package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.entity.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    UserInfoRepositoty userInfoRepositoty;
    @Autowired
    BoardRepository boardRepository;


    @Test
    void relationshipTest1(){ // UserInfo - Board : ManyToOne
        UserInfo user = new UserInfo();
        user.setUsername("2023"); // 아이디 생성
        user.setPassword("0000");
        user.setName("어른이");
        user.setPhone("010-1234-5678");
        user.setGender("여성");
        userInfoRepositoty.save(user);

        Board board = new Board();
        board.setTitle("오운완 1일차");
        board.setContent("유산소+근력");
        board.setSchedule("토요일");
        board.setPlace("하나누리");
        board.setUserInfo(user);
        boardRepository.save(board);

        // TEST
        System.out.println("게사판:"+boardRepository.findById(1L).orElseThrow(RuntimeException::new));

        System.out.println("글 작성자:"+userInfoRepositoty.findById(1L).orElseThrow(RuntimeException::new).getUserId());
    }
}

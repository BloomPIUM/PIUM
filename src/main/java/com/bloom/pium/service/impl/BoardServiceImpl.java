package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.entity.BoardMatching;
import com.bloom.pium.data.repository.BoardRepository;
import com.bloom.pium.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl  implements BoardService {
    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    // 조회
    @Override
    public BoardResponseDto getBoard(Long boardId) {
        BoardMatching boardMatching = boardRepository.findById(boardId).get();
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(boardMatching.getTitle());
        boardResponseDto.setContent(boardMatching.getContent());
        boardResponseDto.setViewCnt(boardMatching.getViewCnt());
        boardResponseDto.setLikeCnt(boardMatching.getLikeCnt());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        BoardMatching boardMatching = new BoardMatching();
        boardMatching.setTitle(boardDto.getTitle());
        boardMatching.setContent(boardDto.getContent());
        boardMatching.setSchedule(boardDto.getSchedule());
        boardMatching.setPlace(boardDto.getPlace());
        boardMatching.setViewCnt(0); // 초기값으로 0 설정
        boardMatching.setLikeCnt(0);
        boardMatching.setCreatedDate(LocalDateTime.now());
        boardMatching.setModifiedDate(LocalDateTime.now());

        BoardMatching savedBoardMatching = boardRepository.save(boardMatching);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardId(savedBoardMatching.getBoardId());
        boardResponseDto.setTitle(savedBoardMatching.getTitle());
        boardResponseDto.setContent(savedBoardMatching.getContent());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto modifyBoard(Long boardId, String title, String content) throws Exception {
        return null;
    }

    @Override
    public void deletBoard(Long boardId) throws Exception {

    }
}

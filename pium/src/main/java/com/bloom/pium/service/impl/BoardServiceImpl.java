package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.repository.BoardRepository;
import com.bloom.pium.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Board board = boardRepository.findById(boardId).get();
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContent(board.getContent());
        boardResponseDto.setViewCnt(board.getViewCnt());
        boardResponseDto.setLikeCnt(board.getLikeCnt());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setSchedule(boardDto.getSchedule());
        board.setPlace(boardDto.getPlace());
        board.setViewCnt(0); // 초기값으로 0 설정
        board.setLikeCnt(0);
        board.setCreatedDate(LocalDateTime.now());
        board.setModifiedDate(LocalDateTime.now());

        Board savedBoard = boardRepository.save(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardId(savedBoard.getBoardId());
        boardResponseDto.setTitle(savedBoard.getTitle());
        boardResponseDto.setContent(savedBoard.getContent());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto modifyBoard(Long boardId, String title, String content) throws Exception {
        return null;
    }

    @Override
    public void deletBoard(Long boardId) throws Exception {

    }

    // ↓↓ 추가 (2023.09.11.월)
    // 게시글 전체 불러오기
    @Override
    public Page<BoardResponseDto> getAllBoards(int page, int size) {
        // 페이지와 페이지 크기를 기반으로 페이징 요청
        Pageable pageable = PageRequest.of(page-1, size); // 1페이지부터 시작

        // 게시물을 페이징하여 가져옴
        Page<Board> boardPage = boardRepository.findAll(pageable);

        // Board엔티티를 BoardResponseDto로 변환하여 반환
        return boardPage.map(this::convertToDto);
    }

    // Board 엔티티를 BoardResponseDto로 변환하는 메서드
    private BoardResponseDto convertToDto(Board board) {
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardId(board.getBoardId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContent(board.getContent());
        boardResponseDto.setViewCnt(board.getViewCnt());
        boardResponseDto.setLikeCnt(board.getLikeCnt());
        return boardResponseDto;
    }
    // ↑↑ 추가 (2023.09.11.월)
}

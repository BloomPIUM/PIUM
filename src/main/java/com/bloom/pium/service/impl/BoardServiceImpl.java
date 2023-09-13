package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.entity.BoardMatching;
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
import java.util.Optional;

@Service
public class BoardServiceImpl  implements BoardService {
    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    private BoardRepository boardRepository;

    private static int size =10;

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
    public void deleteBoard(Long number) throws Exception{
        Optional<BoardMatching> selectedBoard = boardRepository.findById(number);

        if(selectedBoard.isPresent()){
            BoardMatching board = selectedBoard.get();

            boardRepository.delete(board);

        } else{
            throw new Exception();
        }
    }



    // 게시글 전체 불러오기
    @Override
    public Page<BoardResponseDto> getAllBoards(int page) {
        // 페이지와 페이지 크기를 기반으로 페이징 요청
        Pageable pageable = PageRequest.of(page-1, size); // 1페이지부터 시작

        // 게시물을 페이징하여 가져옴
        Page<BoardMatching> boardPage = boardRepository.findAll(pageable);

        // Board엔티티를 BoardResponseDto로 변환하여 반환
        return boardPage.map(this::convertToDto);
    }

    // Board 엔티티를 BoardResponseDto로 변환하는 메서드
    private BoardResponseDto convertToDto(BoardMatching board) {
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardId(board.getBoardId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContent(board.getContent());
        boardResponseDto.setViewCnt(board.getViewCnt());
        boardResponseDto.setLikeCnt(board.getLikeCnt());
        return boardResponseDto;
    }

}


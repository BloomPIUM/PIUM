package com.bloom.pium.service;


import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.BoardResponseDto;

public interface BoardService {
    // 게시글 조회
    BoardResponseDto getBoard(Long boardId);

    // 게시글 작성
    BoardResponseDto saveBoard(BoardDto boardDto);

    // 게시글 수정
    BoardResponseDto modifyBoard(Long boardId, String title, String content) throws Exception;

    //게시글 삭제
    void deletBoard(Long boardId) throws Exception;

}

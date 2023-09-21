package com.bloom.pium.service;


import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.entity.BoardMatching;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {
    // 게시글 조회
    BoardResponseDto getBoard(Long boardId);

    // 게시글 작성
    BoardResponseDto saveBoard(BoardDto boardDto);

    // 게시글 수정
    BoardResponseDto modifyBoard(Long boardId, String title, String content) throws Exception;


    //게시글 삭제
    void  deleteBoard(Long boardId) throws Exception;



    // 전체 게시글 가져오기 (페이징)
    Page<BoardResponseDto> getAllBoards(int page);



    // 게시판 좋아요(추천) 토글 메서드
    BoardResponseDto toggleLike(Long boardId, Long userId);

    // ↓↓ 추가 (2023.09.17.일)
    // no usages 라고 나오지만 지워버리면 실행 안돼요 ㅜㅜ
    // 특정 카테고리의 게시글 불러오기
    List<BoardResponseDto> getBoardMatchingByCategory(Long categoryId);
    // ↑↑ 추가 (2023.09.17.일)


}

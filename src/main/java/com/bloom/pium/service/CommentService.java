package com.bloom.pium.service;

import com.bloom.pium.data.dto.CommentResponseDto;

public interface CommentService {


    // 게시글 댓글 수정

    // 게시글 댓글 작성 -> // 게시글 대댓글 작성
    CommentResponseDto writeComment(Long pComment,CommentResponseDto commentResponseDto);

    // 게시글 대댓글 삭제 - 전체삭제? 삭제 후 남음?
    void DeleteCToComment(Long CommentId);

    // 댓글 정렬



}

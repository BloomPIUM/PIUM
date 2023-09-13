package com.bloom.pium.service;

import com.bloom.pium.data.dto.CommentDto;

public interface CommentService {


    // 게시글 댓글 수정

    // 게시글 댓글 작성 -> // 게시글 대댓글 작성
    CommentDto writeComment(CommentDto commentDto);

    // 게시글 대댓글 삭제 - 전체삭제? 삭제 후 남음?
    void DeleteCToComment(Long commentId);

    // 댓글 조회 -> 댓글 정렬




}

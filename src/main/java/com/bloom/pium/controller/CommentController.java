package com.bloom.pium.controller;

import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.data.dto.CommentResponseDto;
import com.bloom.pium.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 작성 엔드포인트
    @PostMapping("/write")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentDto commentDto) {
        CommentResponseDto commentResponseDto = commentService.saveComment(commentDto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    // 다른 댓글 관련 엔드포인트들 추가 (수정, 삭제, 조회 등)

    }
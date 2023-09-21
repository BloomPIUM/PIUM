package com.bloom.pium.controller;

import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.data.dto.CommentResponseDto;
import com.bloom.pium.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    @Autowired
    CommentController(CommentService commentService){
        this.commentService =commentService;
    }

    @PostMapping("/write")
    @ApiOperation(value = "댓글 작성")
    public ResponseEntity<CommentDto> CommentWrite( CommentDto CommentDto){
        commentService.writeComment(CommentDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommentDto);
    }

    // ↓↓ 추가 (2023.09.16.토)
    @GetMapping("/byBoard/{boardId}")
    @ApiOperation(value = "게시글ID로 댓글 불러오기")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByBoardId(@PathVariable Long boardId) {
        List<CommentResponseDto> comments = commentService.getCommentsByBoardId(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    @GetMapping("/byUser/{userId}")
    @ApiOperation(value = "유저ID로 댓글 불러오기")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByUserId(@PathVariable Long userId) {
        List<CommentResponseDto> comments = commentService.getCommentsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }
    // ↑↑ 추가 (2023.09.16.토)
}

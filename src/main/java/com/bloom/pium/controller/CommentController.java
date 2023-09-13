package com.bloom.pium.controller;

import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    @Autowired
    CommentController(CommentService commentService){
        this.commentService =commentService;
    }

    @PostMapping("/write")
    public ResponseEntity<CommentDto> CommentWrite( CommentDto CommentDto){
        commentService.writeComment(CommentDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommentDto);
    }

}

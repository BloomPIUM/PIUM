package com.bloom.pium.service.impl;


import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.data.dto.CommentResponseDto;
import com.bloom.pium.data.entity.Comment;
import com.bloom.pium.data.repository.CommentRepository;
import com.bloom.pium.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentResponseDto saveComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setUserId(commentDto.getUserId());
        comment.setBoardId(commentDto.getBoardId());
        comment.setCreatedDate(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setCommentId(savedComment.getCommentId());
        commentResponseDto.setContent(savedComment.getContent());
        commentResponseDto.setUserId(savedComment.getUserId());
        commentResponseDto.setBoardId(savedComment.getBoardId());
        commentResponseDto.setCreatedDate(savedComment.getCreatedDate());

        return commentResponseDto;
    }
}

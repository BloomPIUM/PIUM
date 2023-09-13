package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.BoardDto;
import com.bloom.pium.data.dto.CommentResponseDto;
import com.bloom.pium.data.entity.Comment;
import com.bloom.pium.data.repository.BoardRepository;
import com.bloom.pium.data.repository.CommentRepository;
import com.bloom.pium.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private BoardRepository boardRepository;
    @Autowired
    CommentServiceImpl(CommentRepository commentRepository, BoardRepository boardRepository){
        this.commentRepository =commentRepository;
        this.boardRepository =boardRepository;
    }

    @Override
    public CommentResponseDto writeComment(Long pComment, CommentResponseDto commentResponseDto) {
        // 게시글 확인
       // boardRepository.findById(boardId).orElseThrow(RuntimeException::new);

        if(pComment == null){
            // 부모 댓글
            Comment comment = new Comment();
            comment.setContent(commentResponseDto.getContent());

            commentRepository.save(comment);
        }else {
            // 자식 댓글
            Comment comment = new Comment();
            comment.setContent(commentResponseDto.getContent());
            comment.setPComment(commentRepository.findById(pComment).get());

            commentRepository.save(comment);
        }
        return commentResponseDto; //
    }

    @Override
    public void DeleteCToComment(Long CommentId) {

    }


}

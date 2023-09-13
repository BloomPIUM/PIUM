package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.data.entity.Comment;
import com.bloom.pium.data.repository.BoardRepository;
import com.bloom.pium.data.repository.CommentRepository;
import com.bloom.pium.data.repository.UserInfoRepository;
import com.bloom.pium.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private BoardRepository boardRepository;
    private UserInfoRepository userInfoRepository;
    @Autowired
    CommentServiceImpl(CommentRepository commentRepository, BoardRepository boardRepository, UserInfoRepository userInfoRepository){
        this.commentRepository =commentRepository;
        this.boardRepository =boardRepository;
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public CommentDto writeComment(CommentDto commentDto) {

        // 게시글이 없으면
        //boardRepository.findById(commentDto.getBoardId()).orElseThrow(RuntimeException::new);

        // 자식 X
        if(commentDto.getPContentId() == null) {
            Comment comment = new Comment();
            comment.setContent(commentDto.getContent());
            comment.setBoardMatching(boardRepository.findById(commentDto.getBoardId()).get());
            comment.setUserInfo(userInfoRepository.findById(commentDto.getUserId()).get());
            comment.setCreatedDate(LocalDateTime.now());
            comment.setModifiedDate(LocalDateTime.now());

            commentRepository.save(comment);
        }else {

            // 자식 저장
            Comment commentC = new Comment();
            commentC.setContent(commentDto.getContent());
            commentC.setBoardMatching(boardRepository.findById(commentDto.getBoardId()).get());
            commentC.setUserInfo(userInfoRepository.findById(commentDto.getUserId()).get());
            commentC.setPComment(commentRepository.findById(commentDto.getPContentId()).get());
            commentC.setCreatedDate(LocalDateTime.now());
            commentC.setModifiedDate(LocalDateTime.now());
            commentRepository.save(commentC);

            // 부모의 자식 업데이트?

        }
        return commentDto;
    }

    @Override
    public void DeleteCToComment(Long commentId) {
       // 상위 댓글 삭제 시 하위 댓글 전체 삭제


    }


}

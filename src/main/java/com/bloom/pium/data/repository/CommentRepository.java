package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.BoardMatching;
import com.bloom.pium.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
   
   List<Comment> findAllByBoardMatching(Long boardId);

}

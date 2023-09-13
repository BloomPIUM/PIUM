package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment,Long> {

//    @Override
//    <S extends Comment> S save(S entity);
}

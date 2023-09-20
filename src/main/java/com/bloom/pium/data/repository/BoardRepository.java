package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByCategoryId(Long categoryId);
}

package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    // ↓↓ 추가 (2023.09.11.월)
    // 게시물을 페이징하여 가져옴
    Page<Board> findAll(Pageable pageable);
    // ↑↑ 추가 (2023.09.11.월)
}

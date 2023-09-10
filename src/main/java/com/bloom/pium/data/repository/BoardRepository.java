package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}

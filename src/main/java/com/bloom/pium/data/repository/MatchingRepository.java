package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingRepository extends JpaRepository<Matching,Long> {

    List<Matching> findByParticipateTrue();
    // participate값이 true일 경우를 찾음
}

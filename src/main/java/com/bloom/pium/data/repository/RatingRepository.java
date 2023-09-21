package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserUsername(String username);
    List<Rating> findByRatedUserUsername(String ratedUsername);
}


package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 추가 (2023.09.17.일)
}

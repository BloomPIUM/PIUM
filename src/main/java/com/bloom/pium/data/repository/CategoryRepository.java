package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 다른 메서드들...

    Category findByCategoryId(Long categoryId);
    Category save(Category category);
}

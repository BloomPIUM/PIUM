package com.bloom.pium.service;

import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.dto.CategoryDto;
import com.bloom.pium.data.dto.CategoryResponseDto;
import com.bloom.pium.data.entity.Category;
import java.util.List;



public interface CategoryService {
    Category getCategory(String categoryId);


    // 카테고리 생성
    CategoryResponseDto createCategory(CategoryDto categoryDto);

    // 카테고리 수정
    CategoryResponseDto updateCategory(Long categoryId, String newCategoryName) throws Exception;

    // 카테고리 삭제
    void deleteCategory(Long categoryId) throws Exception;
    List<BoardResponseDto> getBoardsByCategory(Long categoryId);
}


package com.bloom.pium.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.dto.CategoryDto;
import com.bloom.pium.data.dto.CategoryResponseDto;
import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.entity.Category;
import com.bloom.pium.data.repository.BoardRepository;
import com.bloom.pium.data.repository.CategoryRepository;
import com.bloom.pium.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, BoardRepository boardRepository) {
        this.categoryRepository = categoryRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public Category getCategory(String categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(Long.valueOf(categoryId));

        if (categoryOptional.isPresent()) {
            return categoryOptional.get(); // 값이 존재할 때만 .get() 호출
        } else {
            // 값이 존재하지 않는 경우에 대한 처리를 여기에 추가
            throw new NoSuchElementException("Category not found for id: " + categoryId);
        }
    }
//    public CategoryResponseDto getCategory(Long categoryId) {
//        Category category = categoryRepository.findById(categoryId).get();
//        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
//        categoryResponseDto.setCategoryName(category.getCategoryName());
//
//        return categoryResponseDto;
//    }


    @Override
    public CategoryResponseDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());

        Category createdCategory = categoryRepository.save(category);

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(createdCategory.getCategoryId());
        categoryResponseDto.setCategoryName(createdCategory.getCategoryName());

        return categoryResponseDto;
    }

    @Override //modify  update
    public CategoryResponseDto updateCategory(Long categoryId, String newCategoryName) {
        Category foundCategory = categoryRepository.findById(categoryId).get();
        foundCategory.setCategoryId(categoryId);
        foundCategory.setCategoryName(newCategoryName);

        Category changedCategory = categoryRepository.save(foundCategory);

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(changedCategory.getCategoryId());
        categoryResponseDto.setCategoryName(changedCategory.getCategoryName());

        return categoryResponseDto;
    }


    @Override
    public void deleteCategory(Long categoryId) throws Exception {

    }

    @Override
    public List<BoardResponseDto> getBoardsByCategory(Long categoryId) {
        // 해당 카테고리 ID로 카테고리 엔티티를 조회
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found for id: " + categoryId));

        // 해당 카테고리에 속한 게시물(Board) 조회
        List<Board> boards = category.getBoards();

        // Board 엔티티를 BoardResponseDto로 변환
        List<BoardResponseDto> boardResponseDtos = boards.stream()
                .map(board -> {
                    BoardResponseDto boardResponseDto = new BoardResponseDto();
                    boardResponseDto.setBoardId(board.getBoardId());
                    boardResponseDto.setTitle(board.getTitle());
                    boardResponseDto.setContent(board.getContent());
                    // 다른 필드들도 필요에 따라 설정
                    return boardResponseDto;
                })
                .collect(Collectors.toList());

        return boardResponseDtos;
    }
}
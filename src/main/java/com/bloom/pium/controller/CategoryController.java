package com.bloom.pium.controller;

import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.dto.CategoryDto;
import com.bloom.pium.data.dto.CategoryResponseDto;
import com.bloom.pium.data.entity.Category;
import com.bloom.pium.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable String categoryId) {
        Optional<Category> categoryOptional = Optional.ofNullable(categoryService.getCategory(categoryId));

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get(); // 값이 존재할 때만 .get() 호출
            return ResponseEntity.ok(category);
        } else {
            // 값이 존재하지 않는 경우에 대한 처리를 여기에 추가
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping()
//    public ResponseEntity<CategoryResponseDto> getCategory(Long categoryId) {
//        CategoryResponseDto categoryResponseDto = categoryService.getCategory(categoryId);
//        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
//    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryResponseDto categoryResponseDto = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }


    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @PathVariable Long categoryId,
            @RequestBody CategoryDto categoryDto) throws Exception {
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(categoryId, String.valueOf(categoryDto));
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) throws Exception {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{categoryId}/boards")
    public ResponseEntity<List<BoardResponseDto>> getBoardsByCategory(@PathVariable Long categoryId) {
        List<BoardResponseDto> boardResponseDtos = categoryService.getBoardsByCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDtos);
    }
}
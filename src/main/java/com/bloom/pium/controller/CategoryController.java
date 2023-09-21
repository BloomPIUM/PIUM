package com.bloom.pium.controller;

import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.dto.CategoryResponseDto;
import com.bloom.pium.data.dto.CategoryDto;
import com.bloom.pium.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    // ↓↓ 추가 (2023.09.17.일)
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ApiOperation(value = "카테고리 생성")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryResponseDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "전체 카테고리")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<CategoryResponseDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "특정 카테고리") // 크게 의미 없는 기능
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "카테고리 수정")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryResponseDto updatedCategory = categoryService.updateCategory(id, categoryDto);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "카테고리 삭제")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/boardMatching")
    @ApiOperation(value = "특정 카테고리의 게시글 불러오기") // 주기능
    public ModelAndView getBoardMatchingByCategory(@PathVariable Long id, Model model) throws IOException {
        List<BoardResponseDto> matchingboards = categoryService.getBoardMatchingByCategory(id);
        ModelAndView modelAndView = new ModelAndView("BoardMatching");
        modelAndView.addObject("matchingboards", matchingboards);
        System.out.println(matchingboards);
        return modelAndView;
    }

}

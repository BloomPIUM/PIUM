package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.BoardMatching;
import com.bloom.pium.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardMatching,Long> {
    // 게시물을 페이징하여 가져옴
    Page<BoardMatching> findAll(Pageable pageable);

    List<BoardMatching> findByCategory(Category category);

    //    // 카테고리 내에서 제목에 해당 키워드가 포함된 글 검색
    //    List<BoardMatching> findByCategoryIdAndTitleContaining(Long categoryId, String keyword);
    //    // 카테고리 내에서 유저 이름에 해당 키워드가 포함된 글 검색
    //    List<BoardMatching> findByCategoryIdAndUserInfoNameContaining(Long categoryId, String keyword);
    List<BoardMatching> findByCategoryIdAndUserInfoNameContaining(Long categoryId, String keyword);
    List<BoardMatching> findTop10ByOrderByCreatedDateDesc();

    List<BoardMatching> findByCategoryIdAndTitleContaining(Long categoryId, String keyword);

    List<BoardMatching> findByUserInfoUserId(Long userId);

    List<BoardMatching> findByUserInfoUserIdOrderByBoardIdDesc(Long userId);

}

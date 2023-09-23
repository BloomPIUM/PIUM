package com.bloom.pium.controller;

import com.bloom.pium.data.dto.RatingDto;
import com.bloom.pium.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // 후기 작성 폼을 보여주는 메서드
    @GetMapping("/form")
    public String showWriteRatingForm(Model model) {
        // 필요한 데이터를 모델에 추가
        // 예: model.addAttribute("categories", categoryService.getAllCategories());
        
        return "Ratingform";
    }



    @PostMapping("/write")
    public String writeRating(@RequestParam String username, @RequestParam String ratedUsername, @RequestParam String content, @RequestParam int rating) {
        // RatingDto 객체를 생성하고 사용자가 제출한 데이터로 채웁니다
        RatingDto ratingDto = new RatingDto();
        ratingDto.setUsername(username);
        ratingDto.setRatedUsername(ratedUsername);
        ratingDto.setContent(content);
        ratingDto.setRating(rating);

        // 서비스 메서드를 호출하여 평가를 저장합니다
        ratingService.writeRating(ratingDto);

        // 성공 페이지 또는 다른 적절한 페이지로 리디렉션합니다
        return "redirect:/ratings/forUser/" + ratedUsername; // 여기에는 성공 페이지의 실제 URL을 입력하세요
    }

    // 특정 유저에 대한 후기 및 별점 조회 메서드
    @GetMapping("/forUser/{ratedUsername}")
    public String getRatingsForUser(@PathVariable String ratedUsername, Model model) {
        List<RatingDto> ratings = ratingService.getRatingsForUser(ratedUsername);
        model.addAttribute("ratings", ratings);
        return "UserRating"; // userRatings.html 템플릿을 사용하여 결과를 보여줌
    }
}

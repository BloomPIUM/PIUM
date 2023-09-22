package com.bloom.pium.controller;

import com.bloom.pium.data.dto.RatingDto;
import com.bloom.pium.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // 후기 작성 API
    @PostMapping("/write")
    public ResponseEntity<RatingDto> writeRating(@RequestBody RatingDto ratingDto) {
        RatingDto result = ratingService.writeRating(ratingDto);
        return ResponseEntity.ok(result);
    }

    // 특정 유저의 후기 및 별점 조회 API
    @GetMapping("/byUser/{username}")
    public ResponseEntity<List<RatingDto>> getRatingsByUser(@PathVariable String username) {
        List<RatingDto> ratings = ratingService.getRatingsByUser(username);
        return ResponseEntity.ok(ratings);
    }

    // 특정 유저에 대한 후기 및 별점 조회 API
    @GetMapping("/forUser/{ratedUsername}")
    public ResponseEntity<List<RatingDto>> getRatingsForUser(@PathVariable String ratedUsername) {
        List<RatingDto> ratings = ratingService.getRatingsForUser(ratedUsername);
        return ResponseEntity.ok(ratings);
    }
}



//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;

//@Controller
//@RequestMapping("/ratings")
//public class RatingController {
//    private final RatingService ratingService;
//
//    @Autowired
//    public RatingController(RatingService ratingService) {
//        this.ratingService = ratingService;
//    }
//
//    // 후기 작성 페이지를 보여주는 메서드
//    @GetMapping("/write")
//    public ModelAndView showWriteRatingForm() {
//        ModelAndView modelAndView = new ModelAndView("write-rating"); // Thymeleaf 템플릿의 이름
//        modelAndView.addObject("ratingDto", new RatingDto()); // 평가 데이터를 전달할 객체 생성
//        return modelAndView;
//    }
//
//    // 후기 작성 처리
//    @PostMapping("/write")
//    public String writeRating(@ModelAttribute RatingDto ratingDto) {
//        // 후기 작성 로직
//        ratingService.writeRating(ratingDto);
//        return "redirect:/ratings/byUser/" + ratingDto.getUsername();
//    }
//
//    // 특정 유저의 후기 및 별점 조회 페이지
//    @GetMapping("/byUser/{username}")
//    public ModelAndView getRatingsByUser(@PathVariable String username) {
//        ModelAndView modelAndView = new ModelAndView("ratings-by-user"); // Thymeleaf 템플릿의 이름
//        List<RatingDto> ratings = ratingService.getRatingsByUser(username);
//        modelAndView.addObject("ratings", ratings); // 평가 목록을 전달
//        return modelAndView;
//    }
//
//    // 특정 유저에 대한 후기 및 별점 조회 페이지
//    @GetMapping("/forUser/{ratedUsername}")
//    public ModelAndView getRatingsForUser(@PathVariable String ratedUsername) {
//        ModelAndView modelAndView = new ModelAndView("ratings-for-user"); // Thymeleaf 템플릿의 이름
//        List<RatingDto> ratings = ratingService.getRatingsForUser(ratedUsername);
//        modelAndView.addObject("ratings", ratings); // 평가 목록을 전달
//        return modelAndView;
//    }
//}
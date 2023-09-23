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
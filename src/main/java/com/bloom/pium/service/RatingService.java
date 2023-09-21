package com.bloom.pium.service;

import com.bloom.pium.data.dto.RatingDto;

import java.util.List;

public interface RatingService {
    RatingDto writeRating(RatingDto ratingDto);
    List<RatingDto> getRatingsByUser(String username);
    List<RatingDto> getRatingsForUser(String ratedUsername);
}

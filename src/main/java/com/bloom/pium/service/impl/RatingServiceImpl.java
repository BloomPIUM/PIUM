package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.RatingDto;
import com.bloom.pium.data.entity.Rating;
import com.bloom.pium.data.entity.UserInfo;
import com.bloom.pium.data.repository.RatingRepository;
import com.bloom.pium.data.repository.UserInfoRepository;
import com.bloom.pium.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final UserInfoRepository userRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, UserInfoRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public RatingDto writeRating(RatingDto ratingDto) {
        // RatingDto에서 필요한 데이터 추출
        String username = ratingDto.getUsername(); // 후기 작성자의 username
        String ratedUsername = ratingDto.getRatedUsername(); // 후기 대상의 username

        // User 엔티티를 username과 ratedUsername으로 조회
        UserInfo user = userRepository.findByUsername(username);
        UserInfo ratedUser = userRepository.findByUsername(ratedUsername);

        // Rating 엔티티 생성
        Rating rating = new Rating();
        rating.setUser(user);
        rating.setRatedUser(ratedUser);
        rating.setContent(ratingDto.getContent());
        rating.setRating(ratingDto.getRating());
        rating.setCreatedDate(ratingDto.getCreatedDate());

        // Rating 엔티티 저장
        rating = ratingRepository.save(rating);

        // 저장된 Rating 엔티티의 정보를 RatingDto로 변환하여 반환
        return convertToRatingDto(rating);
    }

    @Override
    public List<RatingDto> getRatingsByUser(String username) {
        // username을 사용하여 해당 유저가 작성한 후기 및 별점 목록을 조회
        List<Rating> ratings = ratingRepository.findByUserUsername(username);

        // 조회된 Rating 엔티티 목록을 RatingDto 목록으로 변환
        return ratings.stream()
                .map(this::convertToRatingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingsForUser(String ratedUsername) {
        // ratedUsername을 사용하여 해당 유저에 대한 후기 및 별점 목록을 조회
        List<Rating> ratings = ratingRepository.findByRatedUserUsername(ratedUsername);

        // 조회된 Rating 엔티티 목록을 RatingDto 목록으로 변환
        return ratings.stream()
                .map(this::convertToRatingDto)
                .collect(Collectors.toList());
    }


    private RatingDto convertToRatingDto(Rating rating) {
        RatingDto ratingDto = new RatingDto();
        ratingDto.setId(rating.getId());
        ratingDto.setUsername(rating.getUser().getUsername());
        ratingDto.setRatedUsername(rating.getRatedUser().getUsername());
        ratingDto.setContent(rating.getContent());
        ratingDto.setRating(rating.getRating());
        ratingDto.setCreatedDate(rating.getCreatedDate());
        return ratingDto;
    }



}
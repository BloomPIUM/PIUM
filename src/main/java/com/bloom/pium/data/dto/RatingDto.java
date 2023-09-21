package com.bloom.pium.data.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RatingDto {
    private Long id;
    private String username; // 후기 작성자의 username
    private String ratedUsername; // 후기 대상의 username
    private String content;
    private int rating;
    private LocalDateTime createdDate;
    // 생성자, 게터, 세터 등 필요한 메서드를 추가하세요.
}

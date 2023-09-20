package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryName;

    // Getter와 Setter 메서드 생략
}

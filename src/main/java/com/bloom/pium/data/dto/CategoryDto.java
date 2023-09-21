package com.bloom.pium.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    // ↓↓ 추가 (2023.09.17.일)
    private String name;
    // ↑↑ 추가 (2023.09.17.일)
}

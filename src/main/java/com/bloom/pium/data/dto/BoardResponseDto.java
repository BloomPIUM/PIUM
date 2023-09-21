package com.bloom.pium.data.dto;

import com.bloom.pium.data.entity.Board;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardResponseDto extends Board {
    private Long boardId;
    private String title;
    private String content;
    private int likeCnt;
    private int viewCnt;
    // ↓↓ 추가 (2023.09.17.일)
    private String categoryName;
    private boolean participate;
    private String username;
    private int commentCount;
    // ↑↑ 추가 (2023.09.17.일)
}

//ProductResponseDto: 서버에서 클라이언트

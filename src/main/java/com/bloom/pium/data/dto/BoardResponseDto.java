package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String content;
    private int likeCnt;
    private int viewCnt;


}

//ProductResponseDto: 서버에서 클라이언트

package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
    private String title;
    private String content;
    private  String schedule;
    private  String place;

//    private int likeCnt;
//    private int viewCnt;
}

//ProductDto: 클라이언트에서 서버
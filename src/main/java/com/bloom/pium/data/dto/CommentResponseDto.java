package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentResponseDto {
    private  Long commentId;
    private String content;
    private Long pContentId;
//    private Long cContentId;
    private Long boardId;
    private Long userId;

}

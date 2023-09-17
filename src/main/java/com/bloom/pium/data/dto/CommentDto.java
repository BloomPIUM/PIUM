package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDto {

    private Long boardId;
    private Long userId;
    private String content;
    private Long pContentId;
    private Long cContentId;
}

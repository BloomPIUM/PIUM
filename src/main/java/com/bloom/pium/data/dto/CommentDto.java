package com.bloom.pium.data.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDto {

        private String content;
        private Long userId; // 댓글 작성자의 ID
        private Long boardId; // 댓글이 속한 게시글의 ID
        private LocalDateTime createdDate;

    }

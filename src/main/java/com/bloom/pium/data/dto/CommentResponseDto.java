package com.bloom.pium.data.dto;

import com.bloom.pium.data.entity.BaseEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentResponseDto extends BaseEntity { // extends 추가 (2023.09.16.토)

//    private Long commentId; // contentId → commentId 변경 (2023.09.16.토), Impl에서도 안쓸거 같아서 일단은 주석처리
    private String content;
    private Long pContentId;    // 이 값은 왜 있는지 모르겠음
    private Long cContentId;    // 이 값은 왜 있는지 모르겠음
    private Long boardId;
    private Long userId;
    // ↓↓ 추가 (2023.09.17.일)
    private String username;
    // ↑↑ 추가 (2023.09.17.일)
}

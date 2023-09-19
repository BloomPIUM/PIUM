package com.bloom.pium.data.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MessageResponseDto {
    private Long messageId;
    private String messageContent;
    private String messageTitle;
    private LocalDateTime createdDate;
}

    // 생성자, Getter와 Setter 메서드 추가
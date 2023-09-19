package com.bloom.pium.data.dto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MessageDto {
    private Long messageId;

    private String messageTitle;

    private String messageContent;

    private LocalDateTime sentDate;

    private Long senderId; // 발신자의 고유 식별자

    private Long receiverId; // 수신자의 고유 식별자


}

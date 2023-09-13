package com.bloom.pium.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long messageId;
    private Long senderId;
    private Long receiverId;
    private String messageTitle;
    private String messageContent;
    private LocalDateTime createdDate;

    private String senderUsername;
    private String receiverUsername;

}

package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MessageDto {
    private String messageTitle;
    private String content;
    private Long receiveUserName;
    private Long sendUserName;

    private boolean checkStatus; //(true: 읽음, false: 안 읽음)

}

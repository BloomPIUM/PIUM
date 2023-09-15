package com.bloom.pium.service;

import com.bloom.pium.data.dto.MessageDto;

public interface MessageService {
    // 쪽지 작성
    MessageDto writeMessage(MessageDto messageDto);
    // 보낸 쪽지 조회

    // 받은 쪽지 조회

    // 쪽지 확인 여부? 알람?
}

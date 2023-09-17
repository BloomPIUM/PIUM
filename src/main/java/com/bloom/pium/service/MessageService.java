package com.bloom.pium.service;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.data.entity.UserInfo;

public interface MessageService {
    // 쪽지 작성
    MessageDto writeMessage(MessageDto messageDto);
    // 보낸 쪽지 조회

    // 받은 쪽지 조회 -> 안 읽은 쪽지 갯수 조회

    // 쪽지 내용 확인(상세보기) -> 읽음에 따른 상태값 변경 -> 주고 받은 내용?

    // 메세지 읽음에 따른 상태값 변경
    void readMessageStatus(Long messageId);

    // 읽지 않은 쪽지 갯수 조회 = 알림
    int getUnreadMessageCount(UserInfo recipient);
}

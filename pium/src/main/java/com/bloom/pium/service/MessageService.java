package com.bloom.pium.service;

import com.bloom.pium.data.dto.MessageDto;

import java.util.List;

public interface MessageService {

    // 메세지 작성
    MessageDto createMessage(MessageDto messageDto);

    // 메세지 불러오기
    MessageDto getMessageById(Long messageId);

    // 유저 한명이 받은 메세지 전체 불러오기
    List<MessageDto> getMessageByUsername(String username);


//    // 메세지 수정, 없어도 되는 기능임
//    MessageDto updateMessage(Long messageId, MessageDto messageDto);

    // 메세지 삭제
    void deleteMessageById(Long messageId);
}

package com.bloom.pium.service.impl;


import com.bloom.pium.data.dto.MessageResponseDto;
import com.bloom.pium.data.entity.Message;
import com.bloom.pium.data.repository.MessageRepository;
import com.bloom.pium.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageResponseDto> getSentMessagesByUserId(Long userId) {
        List<Message> sentMessages = messageRepository.findMessageBySenderId(userId);
        return convertToResponseDtoList(sentMessages);
    }

    // convertToResponseDtoList 메서드 구현

    private List<MessageResponseDto> convertToResponseDtoList(List<Message> messages) {
        return messages.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    private MessageResponseDto convertToResponseDto(Message message) {
        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setMessageId(message.getMessageId());
        responseDto.setMessageTitle(message.getMessageTitle());
        responseDto.setMessageContent(message.getMessageContent());
        responseDto.setCreatedDate(message.getCreatedDate());
        return responseDto;
    }
}

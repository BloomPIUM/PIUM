package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.data.entity.Message;
import com.bloom.pium.data.entity.UserInfo;
import com.bloom.pium.data.repository.MessageRepository;
import com.bloom.pium.data.repository.UserInfoRepository;
import com.bloom.pium.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserInfoRepository userInfoRepository) {
        this.messageRepository = messageRepository;
        this.userInfoRepository = userInfoRepository;
    }

    // 메세지 작성
    @Override
    public MessageDto createMessage(MessageDto messageDto) {
        UserInfo sender = userInfoRepository.findById(messageDto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        UserInfo receiver = userInfoRepository.findById(messageDto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setMessageTitle(messageDto.getMessageTitle());
        message.setMessageContent(messageDto.getMessageContent());

        Message savedMessage = messageRepository.save(message);

        return mapToDto(savedMessage);
    }

    // 메세지 불러오기
    @Override
    public MessageDto getMessageById(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        return mapToDto(message);
    }

    // 유저 한명이 받은 메세지 전체 불러오기
    @Override
    public List<MessageDto> getMessageByUsername(String username) {
        UserInfo receiver = userInfoRepository.findByUsername(username);

        if (receiver != null) {
            List<Message> messages = messageRepository.findByReceiverUsername(username);
            return messages.stream()
                    .map(message -> {
                        MessageDto messageDto = mapToDto(message);
                        messageDto.setSenderUsername(message.getSender().getUsername());
                        messageDto.setReceiverUsername(message.getReceiver().getUsername());
                        return messageDto;
                    })
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Receiver not found");
        }
    }

//    // 메세지 수정, 없어도 되는 기능임
//    @Override
//    public MessageDto updateMessage(Long messageId, MessageDto messageDto) {
//        Message existingMessage = messageRepository.findById(messageId)
//                .orElseThrow(() -> new RuntimeException("Message not found"));
//        existingMessage.setMessageTitle(messageDto.getMessageTitle());
//        existingMessage.setMessageContent(messageDto.getMessageContent());
//
//        Message updatedMessage = messageRepository.save(existingMessage);
//        return mapToDto(updatedMessage);
//    }

    // 메세지 삭제
    @Override
    public void deleteMessageById(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    private MessageDto mapToDto(Message message) {
        return MessageDto.builder()
                .messageId(message.getMessageId())
                .senderId(message.getSender().getUserId())
                .receiverId(message.getReceiver().getUserId())
                .messageTitle(message.getMessageTitle())
                .messageContent(message.getMessageContent())
                .createdDate(message.getCreatedDate())
                .build();
    }
}



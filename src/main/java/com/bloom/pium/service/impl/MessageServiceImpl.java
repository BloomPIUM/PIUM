package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.data.entity.Message;
import com.bloom.pium.data.entity.UserInfo;
import com.bloom.pium.data.repository.MessageRepository;
import com.bloom.pium.data.repository.UserInfoRepository;
import com.bloom.pium.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private UserInfoRepository userInfoRepository;

    @Autowired
    MessageServiceImpl(MessageRepository messageRepository, UserInfoRepository userInfoRepository){
        this.messageRepository = messageRepository;
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public MessageDto writeMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setMessageTitle(messageDto.getMessageTitle());
        message.setContent(messageDto.getContent());

        UserInfo receiver = userInfoRepository.findById(messageDto.getReceiveUserName())
                .orElseThrow(() -> new RuntimeException("receiver not found"));
        UserInfo sender = userInfoRepository.findById(messageDto.getSendUserName())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        message.setSender(sender);
        message.setRecipient(receiver);
        message.setCreatedDate(LocalDateTime.now());
        message.setCheckStatus(false);
        messageRepository.save(message);

        // 반환용 builder 패턴
        MessageDto messageSave = MessageDto.builder()
                .messageTitle(message.getMessageTitle())
                .content(message.getContent())
                .receiveUserName(message.getRecipient().getUserId())
                .sendUserName(message.getSender().getUserId())
                .checkStatus(message.isCheckStatus())
                .build();

        return messageSave;
    }

    @Override
    public MessageDto readMessageStatus(Long messageId) {
        messageRepository.findById(messageId).orElseThrow(RuntimeException::new);

        Message message = messageRepository.findById(messageId).get();
        message.setCheckStatus(true);
        messageRepository.save(message);

        // 반환용 builder 패턴
        MessageDto messageSave = MessageDto.builder()
                .messageTitle(message.getMessageTitle())
                .content(message.getContent())
                .receiveUserName(message.getRecipient().getUserId())
                .sendUserName(message.getSender().getUserId())
                .checkStatus(message.isCheckStatus())
                .build();

        return messageSave;

    }

    @Override
    public int getUnreadMessageCount(Long recipient) {
        UserInfo recipientUser = userInfoRepository.findById(recipient).get();
        int countUnRead= messageRepository.countByRecipientAndCheckStatus(recipientUser,false);
        return countUnRead;
    }
}

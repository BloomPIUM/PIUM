package com.bloom.pium.controller;


import com.bloom.pium.data.dto.MessageResponseDto;
import com.bloom.pium.data.entity.Message;
import com.bloom.pium.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/sent/{userId}")
    public ResponseEntity<List<MessageResponseDto>> getSentMessagesByUserId(@PathVariable Long userId) {
        List<MessageResponseDto> sentMessages = messageService.getSentMessagesByUserId(userId);
        return new ResponseEntity<>(sentMessages, HttpStatus.OK);
    }

    // 다른 엔드포인트 추가 (받은 쪽지 조회 등)
}
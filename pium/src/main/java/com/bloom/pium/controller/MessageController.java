package com.bloom.pium.controller;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // 메세지 작성
    @PostMapping
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto messageDto) {
        MessageDto createdMessage = messageService.createMessage(messageDto);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    // 메세지 불러오기
    @GetMapping("/{messageId}")
    public ResponseEntity<MessageDto> getMessageById(@PathVariable Long messageId) {
        MessageDto message = messageService.getMessageById(messageId);
        return ResponseEntity.ok(message);
    }

    // 유저 한명이 받은 메세지 전체 불러오기
    @GetMapping("/receiver/{username}")
    public ResponseEntity<List<MessageDto>> getMessageByUsername(@PathVariable String username) {
        List<MessageDto> messages = messageService.getMessageByUsername(username);
        return ResponseEntity.ok(messages);
    }

//    // 메세지 수정, 없어도 되는 기능임
//    @PutMapping("/{messageId}")
//    public ResponseEntity<MessageDto> updateMessage(@PathVariable Long messageId, @RequestBody MessageDto messageDto) {
//        MessageDto updatedMessage = messageService.updateMessage(messageId, messageDto);
//        return ResponseEntity.ok(updatedMessage);
//    }

    // 메세지 삭제
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long messageId) {
        messageService.deleteMessageById(messageId);
        return ResponseEntity.noContent().build();
    }


}

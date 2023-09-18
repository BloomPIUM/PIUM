package com.bloom.pium.controller;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.service.MessageService;
import com.bloom.pium.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MessageController {

    MessageService messageService;

    @Autowired
    MessageController(MessageService messageService){this.messageService = messageService;}

    @PostMapping("/send")
    public ResponseEntity<MessageDto> sendMessage(MessageDto messageDto){
        MessageDto message = messageService.writeMessage(messageDto);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/read/{messageId}")
    public ResponseEntity<MessageDto> readMessage(@PathVariable Long messageId){
        MessageDto message = messageService.readMessageStatus(messageId);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/listCount/{userId}")
    public ResponseEntity<Integer> unReadMessage(@PathVariable Long userId) {
        Integer unreadMessageCount = messageService.getUnreadMessageCount(userId);

        if (unreadMessageCount != null) {
            return ResponseEntity.ok(unreadMessageCount);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

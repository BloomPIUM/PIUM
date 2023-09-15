package com.bloom.pium.controller;

import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.service.MessageService;
import com.bloom.pium.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {

    MessageService messageService;

    @Autowired
    MessageController(MessageService messageService){this.messageService = messageService;}

    @PostMapping
    public ResponseEntity<MessageDto> sendMessage(MessageDto messageDto){
        MessageDto message = messageService.writeMessage(messageDto);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}

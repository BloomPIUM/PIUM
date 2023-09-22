package com.bloom.pium.controller;

import com.bloom.pium.data.dto.MatchingDto;
import com.bloom.pium.data.dto.MessageDto;
import com.bloom.pium.data.dto.MessageResponseDto;
import com.bloom.pium.service.MessageService;
import com.bloom.pium.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    MessageController(MessageService messageService){this.messageService = messageService;}

    @GetMapping("/form")
    public String showMessageForm(Model model) {
        model.addAttribute("messageDto", new MessageDto());
        return "MessageForm";
    }


    @PostMapping("/send")
    public String sendMessage(@ModelAttribute("messageDto") MessageDto messageDto, Model model) {
        MessageDto message = messageService.writeMessage(messageDto);
        model.addAttribute("message",message);
        Long userId = message.getSendId();
        // 리다이렉트 경로에 userId를 포함하여 전달
        return "redirect:/message/sent/" + userId;
    }
//



    // 유저 보낸
    @GetMapping("/sent/{userId}")
    public String getSentMessagesByUserId(@PathVariable Long userId, Model model) {
        List<MessageDto> sentMessages = messageService.getSentMessagesByUserId(userId);
        model.addAttribute("sentMessages", sentMessages);
        return "sentMessages";
    }

    // 유저 받은
    @GetMapping("/receiver/{username}")
    public String getMessageByUsername(@PathVariable String username, Model model) {
        List<MessageDto> messages = messageService.getMessageByUsername(username);
        model.addAttribute("receivedMessages", messages);


        return "receivedMessages";
    }




    // 상세 메세지
    @GetMapping("/read/{messageId}")
    public String readMessage(@PathVariable Long messageId, Model model) {
        MessageDto message = messageService.readMessageStatus(messageId);
        model.addAttribute("message", message);

        return "messageDetails";
    }

    // 상세 메세지
    @GetMapping("/selete/{messageId}")
    public String seleteMessage(@PathVariable Long messageId, Model model) {
        MessageDto message = messageService.readMessageDetail(messageId);
        model.addAttribute("message", message);

        return "messageDetails";
    }




    // 메세지 삭제
    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long messageId) {
        messageService.deleteMessageById(messageId);
        return ResponseEntity.noContent().build();
    }


}

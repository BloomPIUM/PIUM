package com.bloom.pium.service;

import com.bloom.pium.data.dto.MessageResponseDto;
import com.bloom.pium.data.entity.UserInfo;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageService {
    List<MessageResponseDto> getSentMessagesByUserId(Long userId);
}

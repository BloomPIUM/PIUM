package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverUsername(String username);
}

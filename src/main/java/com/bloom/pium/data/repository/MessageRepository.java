package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// MessageRepository 인터페이스
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m join m.sender s where s.userId = :senderId")
        // 이 쿼리 부분이 문제의 뿌리 이부분 자체를 인식 못해 애먹음 심도 있는 공부가 절실히 필요함.

    List<Message> findMessageBySenderId(Long senderId);
}
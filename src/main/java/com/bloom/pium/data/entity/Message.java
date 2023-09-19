package com.bloom.pium.data.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="message")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(nullable = false)
    private String messageTitle;

    @Column(nullable = false)
    private String messageContent; //ERD는 content라 표기돼 있지만 명확한 표기를 위해 messageContent로 작성함.

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdDate; // 댓글 작성일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId", nullable = false)
    private UserInfo sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId", nullable = false)
    private UserInfo receiver;


}


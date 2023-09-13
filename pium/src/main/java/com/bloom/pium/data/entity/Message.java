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
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId", nullable = false)
    private UserInfo sender;    // 보낸사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId", nullable = false)
    private UserInfo receiver;  // 받는사람

    @Column(nullable = false)
    private String messageTitle;

    @Column(nullable = false)
    private String messageContent;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdDate;
}

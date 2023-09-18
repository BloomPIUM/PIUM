package com.bloom.pium.data.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserInfo recipient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserInfo sender;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean checkStatus;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

}

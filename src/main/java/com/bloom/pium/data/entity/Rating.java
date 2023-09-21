package com.bloom.pium.data.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "user_id")
    //@JoinColumn(name = "username")
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "rated_user_id")
    //@JoinColumn(name = "ratedusername")
    private UserInfo ratedUser;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdDate;

    private String content;
    private int rating;

    // 생성자, 게터, 세터 등 필요한 메서드를 추가하세요.
}

package com.bloom.pium.data.entity;

import lombok.*;

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
@Table(name="board")
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private  String schedule;

    @Column(nullable = false)
    private String place;

    @Column(nullable = true)
    private int likeCnt;

    @Column(nullable = true)
    private int viewCnt;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ToString.Exclude
    private UserInfo userInfo;


}

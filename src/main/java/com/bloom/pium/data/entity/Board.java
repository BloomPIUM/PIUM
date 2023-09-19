package com.bloom.pium.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="board")
public class Board {
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

    private LocalDateTime createdDate;

    private  LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "category_id")    // 운동장비 추천 게시물 매니투원
    private Category category;

    // Getter와 Setter 메서드는 생략

    // 생성자와 추가 메서드도 필요할 것
}
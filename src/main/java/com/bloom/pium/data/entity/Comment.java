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
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId; //PK 댓글 아이디

    @Column(nullable = false)
    private String content; // 댓글내용

    private LocalDateTime createdDate; // 댓글 작성일

    @ManyToOne //댓글에서 유저를 바라 볼때
    private UserInfo userInfo; // 유저정보 Entity

    @ManyToOne //댓글에서 보드를 바라 볼때
    private Board board; //게시판 Entity


    // 댓글 작성자의 사용자 ID
    @Column(nullable = false)
    private Long userId;

    // 댓글이 속한 게시글의 ID
    @Column(nullable = false)
    private Long boardId;

}

package com.bloom.pium.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="boardMatching")
public class BoardMatching extends Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

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

//    @OneToMany(mappedBy = "boardMatching", fetch =FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @Column(unique = false)
//    private List<Comment> comment;


}

package com.bloom.pium.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="matching")
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingId;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private boolean participate;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;
    @ManyToOne
    @JoinColumn(name="userId")
    private UserInfo userinfo;
}

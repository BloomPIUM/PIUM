package com.bloom.pium.data.dto;

import com.bloom.pium.data.entity.Board;
import com.bloom.pium.data.entity.BoardMatching;
import com.bloom.pium.data.entity.UserInfo;
import lombok.*;
import org.apache.catalina.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardResponseDto extends Board {
    private Long boardId;
    private String title;
    private String content;
    private int likeCnt;
    private int viewCnt;
    private boolean participate;
    private String categoryName;
    private String username;
    private int commentCount;
    private  String schedule;
    private  String place;

    public BoardResponseDto(BoardMatching boardMatching) {
        this.boardId = boardMatching.getBoardId();
        this.title = boardMatching.getTitle();
        this.likeCnt = boardMatching.getLikeCnt();
        this.viewCnt = boardMatching.getViewCnt();
        this.commentCount = boardMatching.getCommentCount();
        this.username = boardMatching.getUserInfo().getUsername();
        this.setCreatedDate(boardMatching.getCreatedDate());
    }
}

//ProductResponseDto: 서버에서 클라이언트

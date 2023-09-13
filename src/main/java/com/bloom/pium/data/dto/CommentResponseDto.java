package com.bloom.pium.data.dto;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long commentId;
    private String content;
    private Long userId; // 댓글 작성자의 고유 식별자
    private Long boardId; // 댓글이 속한 게시글의 고유 식별자
    private LocalDateTime createdDate;

    // Getter와 Setter 메서드 추가

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

package com.example.board.repository.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRegistResDto {
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean isDeleted;
    private long memberId;
    private long parentComId;
}

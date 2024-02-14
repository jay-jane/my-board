package com.example.board.repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentVO {
    private long id;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean isDeleted;
    private long memberId;
    private long boardId;
    private long parentComId;
}

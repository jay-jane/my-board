package com.example.board.repository.comment;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class CommentRegistResDto {
    private long id;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean isDeleted;
    private long memberId;
    private long parentComId;

    private String nickname;
}

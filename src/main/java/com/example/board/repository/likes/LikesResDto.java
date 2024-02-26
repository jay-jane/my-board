package com.example.board.repository.likes;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LikesResDto {
    private long id;
    private long memberId;
    private long boardId;
    private LocalDateTime regDate;
}

package com.example.board.repository.board;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private long views;
    private boolean isDeleted;

    private String memberId;
    private String nickname;
    private String likes;
}

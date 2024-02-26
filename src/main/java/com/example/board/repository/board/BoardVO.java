package com.example.board.repository.board;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardVO {
    private long id;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private long views;
    private boolean isDeleted;
    private long memberId;
}

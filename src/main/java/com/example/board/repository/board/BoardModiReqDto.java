package com.example.board.repository.board;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BoardModiReqDto {
    private String id;
    private String title;
    private String content;

    private long memberId;
}

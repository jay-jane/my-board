package com.example.board.repository;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;
    private long views;
}

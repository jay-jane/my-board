package com.example.board.repository;

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
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;
    private long views;
    private boolean is_deleted;
    private long member_id;
}

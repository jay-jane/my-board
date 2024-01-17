package com.example.board.command;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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

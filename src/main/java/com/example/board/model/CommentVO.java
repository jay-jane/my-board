package com.example.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentVO {
    private long id;
    private String content;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;
    private boolean is_deleted;
    private long member_id;
    private long board_id;
    private long parent_com_id;
}

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
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;
    private boolean is_deleted;
    private long member_id;
    private long board_id;
    private long parent_com_id;
}

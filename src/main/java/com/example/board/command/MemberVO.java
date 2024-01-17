package com.example.board.command;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MemberVO {
    private long id;
    private String login_id;
    private String password;
    private String name;
    private String nickname;
    private LocalDate birth;
    private String phone;
    private String email;
    private LocalDateTime join_date;
    private LocalDateTime last_login_date;
    private boolean is_deleted;
}

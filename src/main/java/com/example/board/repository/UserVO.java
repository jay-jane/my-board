package com.example.board.repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserVO {
    private long id;
    private String username;
    private String password;
    private String name;
    private String nickname;
    private LocalDate birth;
    private String phone;
    private String email;
    private LocalDateTime join_date;
    private LocalDateTime last_login_date;
    private boolean is_deleted;
    private String role;
    private String provider;
    private String provider_id;
}

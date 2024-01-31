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
@Data
public class UserVO {
    private long id;
    private String loginId;
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

    public UserVO(String loginId, String password, String role, String provider, String provider_id) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.provider_id = provider_id;
    }
}

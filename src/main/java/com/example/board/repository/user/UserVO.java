package com.example.board.repository.user;

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
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private LocalDate birth;
    private String phone;
    private String email;
    private LocalDateTime joinDate;
    private LocalDateTime lastLoginDate;
    private boolean is_deleted;
    private String role;
    private String provider;
    private String providerId;

    public UserVO(String loginId, String password, String role, String provider, String providerId) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}

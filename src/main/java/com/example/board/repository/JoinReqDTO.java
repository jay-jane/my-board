package com.example.board.repository;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class JoinReqDTO {
    private String username;
    private String password;
    private String name;
    private String nickname;
    private LocalDate birth;
    private String phone;
    private String email;
    private String role;
    private String provider;
    private String provider_id;
}

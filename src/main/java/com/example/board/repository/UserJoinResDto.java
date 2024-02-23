package com.example.board.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinResDto {
    private String nickname;
    private String role;
    private String message;

    public UserJoinResDto(String message) {
        this.message = message;
    }
}

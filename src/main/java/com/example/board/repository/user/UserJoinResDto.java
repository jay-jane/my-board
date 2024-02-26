package com.example.board.repository.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

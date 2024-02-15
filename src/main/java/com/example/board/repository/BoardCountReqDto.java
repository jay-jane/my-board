package com.example.board.repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCountReqDto {
    private String title;
    private String nickname;

    public BoardCountReqDto(String title, String nickname) {
        this.title = title;
        this.nickname = nickname;
    }
}

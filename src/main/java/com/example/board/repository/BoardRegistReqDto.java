package com.example.board.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardRegistReqDto {
    private String title;
    private String content;

    public BoardRegistReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.example.board.repository.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardRegistReqDto {
    private String title;
    private String content;
    private long memberId;

    public BoardRegistReqDto(String title, String content, long memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }
}

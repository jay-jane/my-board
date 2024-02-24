package com.example.board.repository.board;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardCountReqDto {
    private String category;
    private String keyword;

    public BoardCountReqDto(String category, String keyword) {
        this.category = category;
        this.keyword = keyword;
    }
}

package com.example.board.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeVO {
    private long id;
    private long memberId;
    private long boardId;
}

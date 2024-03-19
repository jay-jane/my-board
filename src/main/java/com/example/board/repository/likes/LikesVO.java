package com.example.board.repository.likes;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikesVO {
    private long id;
    private long memberId;
    private long boardId;
}

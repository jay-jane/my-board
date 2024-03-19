package com.example.board.repository.likes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikesReqDto {

    private long id;

    private long memberId;
    private long boardId;

    public LikesReqDto(long id) {
        this.id = id;
    }

    public LikesReqDto(long memberId, long boardId) {
        this.memberId = memberId;
        this.boardId = boardId;
    }
}

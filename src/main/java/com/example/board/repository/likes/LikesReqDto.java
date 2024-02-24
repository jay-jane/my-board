package com.example.board.repository.likes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesReqDto {

    private long memberId;
    private long boardId;

    public LikesReqDto(long memberId, long boardId) {
        this.memberId = memberId;
        this.boardId = boardId;
    }
}

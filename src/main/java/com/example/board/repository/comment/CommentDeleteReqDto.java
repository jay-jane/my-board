package com.example.board.repository.comment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDeleteReqDto {
    private long id;
    private long memberId;
    private long boardId;
}

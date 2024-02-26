package com.example.board.repository.comment;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRegistReqDto {
    private long id;
    private String content;
    private long memberId;
    private long boardId;
}

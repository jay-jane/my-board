package com.example.board.repository.comment;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRegistReqDto {
    private long id;
    @NotBlank(message = "내용을 입력해 주세요")
    private String content;
    private long memberId;
    private long boardId;
}

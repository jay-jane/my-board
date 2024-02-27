package com.example.board.service.comment;

import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.repository.comment.CommentRegistResDto;

import java.util.List;

public interface CommentService {

    CommentRegistResDto registComment(CommentRegistReqDto reqDto);

    List<CommentRegistResDto> getCommentList(long boardId);
}

package com.example.board.service.comment;

import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.repository.comment.CommentRegistResDto;

public interface CommentService {

    CommentRegistResDto registComment(CommentRegistReqDto reqDto);
}

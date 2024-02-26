package com.example.board.service.comment;

import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.repository.comment.CommentRegistResDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void registComment(CommentRegistReqDto reqDto);

    CommentRegistResDto findById(long id);
}

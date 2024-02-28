package com.example.board.service.comment;

import com.example.board.repository.comment.CommentDeleteReqDto;
import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.repository.comment.CommentRegistResDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void registComment(CommentRegistReqDto reqDto);

    CommentRegistResDto findById(long id);

    List<CommentRegistResDto> getCommentList(long boardId);

    int deleteComment(CommentDeleteReqDto reqDto);
}

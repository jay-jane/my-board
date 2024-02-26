package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.repository.likes.LikesResDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesMapper {

    void addLikes(LikesReqDto reqDto);

    int deleteLikes(LikesReqDto reqDto);

    int getLikes(long boardId);

    boolean checkLikes(LikesReqDto reqDto);

    LikesResDto findById(long id);
}

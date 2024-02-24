package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesMapper {

    int addLikes(LikesReqDto reqDto);

    int deleteLikes(LikesReqDto reqDto);
}

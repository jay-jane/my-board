package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;

public interface LikesService {

    int addLikes(LikesReqDto reqDto);

    int deleteLikes(LikesReqDto reqDto);

    int getLikes(long boardId);
}

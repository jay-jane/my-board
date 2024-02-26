package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.repository.likes.LikesResDto;
import org.springframework.http.ResponseEntity;

public interface LikesService {

    LikesResDto addLikes(LikesReqDto reqDto);

    int deleteLikes(LikesReqDto reqDto);

    int getLikes(long boardId);

    boolean checkLikes(LikesReqDto reqDto);
}

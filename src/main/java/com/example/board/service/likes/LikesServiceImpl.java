package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.repository.likes.LikesResDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {

    private final LikesMapper likesMapper;

    private static final Logger logger = LoggerFactory.getLogger(LikesServiceImpl.class);

    @Override
    public LikesResDto addLikes(LikesReqDto reqDto) {
        if (checkLikes(reqDto)) {
            if (deleteLikes(reqDto) == 1) {
                return null;
            }
        }
        likesMapper.addLikes(reqDto);
        return likesMapper.findById(reqDto.getId());
    }

    @Override
    public int deleteLikes(LikesReqDto reqDto) {
        return likesMapper.deleteLikes(reqDto);
    }

    @Override
    public int getLikes(long boardId) {
        return likesMapper.getLikes(boardId);
    }

    @Override
    public boolean checkLikes(LikesReqDto reqDto) {
        return likesMapper.checkLikes(reqDto);
    }
}

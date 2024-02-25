package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {

    private final LikesMapper likesMapper;

    private static final Logger logger = LoggerFactory.getLogger(LikesServiceImpl.class);

    @Override
    public int addLikes(LikesReqDto reqDto) {
        if (likesMapper.checkLikes(reqDto)) {
            return likesMapper.deleteLikes(reqDto);
        }
        return likesMapper.addLikes(reqDto);
    }

    @Override
    public int deleteLikes(LikesReqDto reqDto) {
        return likesMapper.deleteLikes(reqDto);
    }

    @Override
    public int getLikes(long boardId) {
        return likesMapper.getLikes(boardId);
    }
}

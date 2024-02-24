package com.example.board.service.likes;

import com.example.board.repository.likes.LikesReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {

    private final LikesMapper likesMapper;

    @Override
    public int addLikes(LikesReqDto reqDto) {
        return likesMapper.addLikes(reqDto);
    }

    @Override
    public int deleteLikes(LikesReqDto reqDto) {
        return likesMapper.deleteLikes(reqDto);
    }
}

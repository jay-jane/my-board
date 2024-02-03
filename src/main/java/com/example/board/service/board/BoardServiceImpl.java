package com.example.board.service.board;

import com.example.board.repository.BoardRegistReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public int registPost(BoardRegistReqDTO boardRegistReqDTO) {
        return boardMapper.registPost(boardRegistReqDTO);
    }
}

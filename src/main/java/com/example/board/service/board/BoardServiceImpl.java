package com.example.board.service.board;

import com.example.board.repository.BoardRegistReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int registPost(BoardRegistReqDTO boardRegistReqDTO) {
        return boardMapper.registPost(boardRegistReqDTO);
    }
}

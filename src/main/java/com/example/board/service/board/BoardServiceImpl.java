package com.example.board.service.board;

import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public int registPost(BoardRegistReqDto boardRegistReqDTO) {
        return boardMapper.registPost(boardRegistReqDTO);
    }

    @Override
    public List<BoardListResDto> getBoardContent() {
        return boardMapper.getBoardContent();
    }

    @Override
    public BoardListResDto getBoardDetail(String boardId) {
        return boardMapper.getBoardDetail(boardId);
    }
}

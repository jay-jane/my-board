package com.example.board.service.board;

import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;

import java.util.List;

public interface BoardService {

    public int registPost(BoardRegistReqDto boardRegistReqDTO);

    public List<BoardListResDto> getBoardContent();

    public BoardListResDto getBoardDetail(String boardId);
}

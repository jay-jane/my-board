package com.example.board.service.board;

import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int registPost(BoardRegistReqDto boardRegistReqDTO);

    public List<BoardListResDto> getBoardContent();

    public BoardListResDto getBoardDetail(String memberId);
}

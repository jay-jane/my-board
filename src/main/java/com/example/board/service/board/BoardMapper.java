package com.example.board.service.board;

import com.example.board.repository.BoardRegistReqDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    public int registPost(BoardRegistReqDTO boardRegistReqDTO);
}

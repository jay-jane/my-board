package com.example.board.service.board;

import com.example.board.repository.board.BoardCountReqDto;
import com.example.board.repository.board.BoardListResDto;
import com.example.board.repository.board.BoardModiReqDto;
import com.example.board.repository.board.BoardRegistReqDto;
import com.example.board.util.RequestList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    int registPost(BoardRegistReqDto boardRegistReqDto);

    int modifyPost(BoardModiReqDto reqDto);

    int deletePost(long boardId);

    BoardListResDto getBoardDetail(long memberId);

    List<Map<String, Object>> getBoardList(RequestList<?> requestList);

    int getBoardListCount(BoardCountReqDto dto);

    void getPostView(long boardId);
}

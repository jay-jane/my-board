package com.example.board.service.board;

import com.example.board.repository.BoardCountReqDto;
import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardModiReqDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.util.RequestList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    int registPost(BoardRegistReqDto boardRegistReqDto);

    int modifyPost(BoardModiReqDto reqDto);

    int deletePost(String boardId);

    BoardListResDto getBoardDetail(String memberId);

    List<Map<String, Object>> getBoardList(RequestList<?> requestList);

    int getBoardListCount(BoardCountReqDto dto);

    void getPostView(String boardId);
}

package com.example.board.service.board;

import com.example.board.repository.BoardCountReqDto;
import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardModiReqDto;
import com.example.board.repository.BoardRegistReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BoardService {

    int registPost(BoardRegistReqDto boardRegistReqDto);

    int modifyPost(BoardModiReqDto reqDto);

    int deletePost(String boardId);

    BoardListResDto getBoardDetail(String boardId);

    Page<Map<String, Object>> getBoardList(BoardCountReqDto dto, Pageable pageable);
}

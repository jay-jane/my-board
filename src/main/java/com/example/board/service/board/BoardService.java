package com.example.board.service.board;

import com.example.board.repository.board.BoardCountReqDto;
import com.example.board.repository.board.BoardModiReqDto;
import com.example.board.repository.board.BoardRegistReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BoardService {

    int registPost(BoardRegistReqDto boardRegistReqDto);

    int modifyPost(BoardModiReqDto reqDto);

    int deletePost(long boardId);

    ResponseEntity<?> getBoardDetail(long boardId);

    Page<Map<String, Object>> getBoardList(BoardCountReqDto dto, Pageable pageable);
}

package com.example.board.controller;

import com.example.board.repository.BoardCountReqDto;
import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.service.board.BoardMapper;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final BoardService boardService;

    private final BoardMapper boardMapper;

    @PostMapping("/registPost")
    public int registPost(@RequestBody BoardRegistReqDto boardRegistReqDTO) {
        return boardService.registPost(boardRegistReqDTO);
    }

    @GetMapping("/getBoardDetail")
    public BoardListResDto getBoardDetail(String boardId) {
        return boardService.getBoardDetail(boardId);
    }

    @GetMapping("/getBoardList")
    public ResponseEntity<?> getBoardList(BoardCountReqDto dto, Pageable pageable) {
        return ResponseEntity.ok(boardService.getBoardList(dto, pageable));
    }

    @GetMapping("/getBoardListCount")
    public int getBoardListCount(@RequestParam(value = "category", required = false) String category,
                                 @RequestParam(value = "keyword", required = false) String keyword) {
        BoardCountReqDto dto = new BoardCountReqDto(category, keyword);
        return boardMapper.getBoardListCount(dto);
    }
}

package com.example.board.controller;

import com.example.board.repository.board.BoardCountReqDto;
import com.example.board.repository.board.BoardModiReqDto;
import com.example.board.repository.board.BoardRegistReqDto;
import com.example.board.service.board.BoardMapper;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    private final BoardMapper boardMapper;

    @PostMapping("/registPost")
    public int registPost(@RequestBody BoardRegistReqDto boardRegistReqDto) {
        return boardService.registPost(boardRegistReqDto);
    }

    @PatchMapping("/modifyPost")
    public int modifyPost(@RequestBody BoardModiReqDto reqDto) {
        return boardService.modifyPost(reqDto);
    }

    @PatchMapping("/deletePost")
    public int deletePost(@RequestBody BoardModiReqDto reqDto) {
        return boardService.deletePost(reqDto.getId());
    }

    @GetMapping("/getBoardDetail")
    public ResponseEntity<?> getBoardDetail(long boardId) {
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

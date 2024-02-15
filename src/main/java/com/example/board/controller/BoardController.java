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

    @GetMapping("/getBoardContent")
    public List<BoardListResDto> getBoardContent() {
        return boardService.getBoardContent();
    }

    @GetMapping("/getBoardDetail")
    public BoardListResDto getBoardDetail(String boardId) {
        return boardService.getBoardDetail(boardId);
    }

    @GetMapping("/paging")
    public ResponseEntity<?> getList(BoardCountReqDto dto, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(boardService.getBoardList(dto, pageable));
    }

    @GetMapping("/getListCount") //검색 기능에 추가할 것
    public int getListCount(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "nickname", required = false) String nickname) {
        BoardCountReqDto dto = new BoardCountReqDto(title, nickname);
        return boardMapper.getBoardListCount(dto);
    }
}

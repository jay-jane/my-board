package com.example.board.controller;

import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

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
}

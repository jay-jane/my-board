package com.example.board.controller;

import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

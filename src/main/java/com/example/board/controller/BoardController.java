package com.example.board.controller;

import com.example.board.repository.BoardRegistReqDTO;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/registPost")
    public int registPost(@RequestBody BoardRegistReqDTO boardRegistReqDTO) {
        return boardService.registPost(boardRegistReqDTO);
    }
}

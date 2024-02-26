package com.example.board.controller;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.service.likes.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/addLikes")
    public ResponseEntity<?> addLikes(@RequestBody LikesReqDto reqDto) {
        return ResponseEntity.status(HttpStatus.OK).body(likesService.addLikes(reqDto));
    }

    @DeleteMapping("/deleteLikes")
    public int deleteLikes(@RequestBody LikesReqDto reqDto) {
        return likesService.deleteLikes(reqDto);
    }

    @GetMapping("/getLikes")
    public int getLikes(@RequestParam long boardId) {
        return likesService.getLikes(boardId);
    }
}

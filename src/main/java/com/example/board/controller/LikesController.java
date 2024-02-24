package com.example.board.controller;

import com.example.board.repository.likes.LikesReqDto;
import com.example.board.service.likes.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/addLikes")
    public int addLikes(@RequestBody LikesReqDto reqDto) {
        return likesService.addLikes(reqDto);
    }

    @DeleteMapping("/deleteLikes")
    public int deleteLikes(@RequestBody LikesReqDto reqDto) {
        return likesService.deleteLikes(reqDto);
    }
}

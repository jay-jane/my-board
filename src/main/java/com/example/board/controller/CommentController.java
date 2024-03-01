package com.example.board.controller;

import com.example.board.repository.comment.CommentDeleteReqDto;
import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.service.comment.CommentService;
import com.example.board.service.likes.LikesServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @PostMapping("/registComment")
    public ResponseEntity<?> registComment(@Valid @RequestBody CommentRegistReqDto reqDto) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.registComment(reqDto));
    }

    @PatchMapping("/deleteComment")
    public int deleteComment(@RequestBody CommentDeleteReqDto reqDto) {
        return commentService.deleteComment(reqDto);
    }
}

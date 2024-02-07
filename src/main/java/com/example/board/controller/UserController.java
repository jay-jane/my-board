package com.example.board.controller;

import com.example.board.repository.UserJoinReqDto;
import com.example.board.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final UserService userService;

    @PostMapping("/signinForm") //회원가입
    public ResponseEntity<?> signInForm(@Valid @RequestBody UserJoinReqDto userJoinReqDTO, BindingResult bindingResult) {
        Map<String, String> result = userService.validateHandling(bindingResult);

        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.join(userJoinReqDTO));
    }

    @GetMapping("/checkLoginId")
    public boolean checkLoginId(@RequestParam(value = "loginId", required = false) String id) {
        return userService.checkLoginId(id);
    }

    @GetMapping("/checkNickname")
    public boolean checkNickname(@RequestParam(value = "nickname", required = false) String nickname) {
        return userService.checkNickname(nickname);
    }
}

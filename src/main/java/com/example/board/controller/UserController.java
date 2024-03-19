package com.example.board.controller;

import com.example.board.repository.user.UserJoinReqDto;
import com.example.board.repository.user.UserModiReqDto;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @PostMapping("/signinForm") //회원가입
    public ResponseEntity<?> signInForm(@Valid @RequestBody UserJoinReqDto userJoinReqDTO, BindingResult bindingResult) {
        Map<String, String> result = userService.validateHandling(bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.join(userJoinReqDTO));
    }

    @PatchMapping("/modifyUser") //회원정보수정
    public ResponseEntity<?> modifyUser(@Valid @RequestBody UserModiReqDto reqDto, BindingResult bindingResult) {
        Map<String, String> result = userService.validateHandling(bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUser(reqDto));
    }

    @PatchMapping("/modifyPassword")
    public ResponseEntity<?> modifyPassword(@Valid @RequestBody UserModiReqDto reqDto, BindingResult bindingResult) {
        Map<String, String> result = userService.validateHandling(bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        } else {
            if (checkPassword(reqDto)) {
                return ResponseEntity.status(HttpStatus.OK).body(userService.modifyPassword(reqDto));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(0);
    }

    @DeleteMapping("/deleteUser") //회원탈퇴
    public int deleteUser(@RequestBody UserModiReqDto reqDto) {
        if (checkPassword(reqDto)) {
            return userService.deleteUser(reqDto.getId());
        }
        return 0;
    }

    @GetMapping("/checkLoginId")
    public boolean checkLoginId(@RequestParam(value = "loginId", required = false) String id) {
        return userService.checkLoginId(id);
    }

    @GetMapping("/checkNickname")
    public boolean checkNickname(@RequestParam(value = "nickname", required = false) String nickname) {
        return userService.checkNickname(nickname);
    }

    @PostMapping("/checkPassword")
    public boolean checkPassword(@RequestBody UserModiReqDto reqDto) {
        return userService.checkPassword(reqDto.getId(), reqDto.getPassword());
    }
}

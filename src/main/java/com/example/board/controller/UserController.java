package com.example.board.controller;

import com.example.board.controller.IndexController;
import com.example.board.repository.UserJoinReqDTO;
import com.example.board.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserService userService;

    @PostMapping("/signinForm") //회원가입
    public String signInForm(@Valid UserJoinReqDTO userJoinReqDTO) {
//        logger.info("user : {}", joinReqDTO.toString());
        userJoinReqDTO.setRole("ROLE_MEMBER");
        String rawPassword = userJoinReqDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinReqDTO.setPassword(encPassword);
        userService.join(userJoinReqDTO);

        return "redirect:/login";
    }

    @GetMapping("/checkLoginId")
    public boolean checkLoginId(@RequestParam(value = "loginId", required = false) String id) {
        logger.info("아이디 중복 검사값 : {}", id);

        return userService.checkLoginId(id);
    }

    @GetMapping("/checkNickname")
    public boolean checkNickname(@RequestParam(value = "nickname", required = false) String nickname) {
        return userService.checkNickname(nickname);
    }
}

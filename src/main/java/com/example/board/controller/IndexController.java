package com.example.board.controller;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.repository.UserJoinReqDTO;
import com.example.board.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final UserService userService;

    @GetMapping(value = {"/", "/board"}) //일반, OAuth 로그인 모두 PrincipalDetails에 정보를 담을 수 있음
    public String mainPage(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        if (principalDetails != null) {
            model.addAttribute("nickname", principalDetails.getUserVO().getNickname());
        }
        return "board-main";
    }

    @GetMapping("/login")
    public String logIn(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        Model model) {
            model.addAttribute("exception", exception);
            model.addAttribute("error", error);
        return "log-in";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "my-page";
    }

    @GetMapping("/board/write")
    public String boardWrite() {
        return "board-write";
    }

    @GetMapping("/board/view")
    public String boardView() {
        return "board-view";
    }
}

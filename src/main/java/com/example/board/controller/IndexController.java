package com.example.board.controller;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.repository.JoinReqDTO;
import com.example.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = {"/", "/board"}) //일반, OAuth 로그인 모두 PrincipalDetails에 정보를 담을 수 있음
    public String mainPage(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        if (principalDetails != null) {
//            logger.info("user role : {}", principalDetails.getUserVO().getRole());
            model.addAttribute("nickname", principalDetails.getUserVO().getNickname());
        }
        return "board-main";
    }

    @GetMapping("/login")
    public String logIn() {
        return "log-in";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "sign-in";
    }

    @PostMapping("/signinForm")
    public String signInForm(JoinReqDTO joinReqDTO) {
//        logger.info("user : {}", joinReqDTO.toString());
        joinReqDTO.setRole("MEMBER");
        String rawPassword = joinReqDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        joinReqDTO.setPassword(encPassword);
        userService.join(joinReqDTO);

        return "redirect:/login";
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

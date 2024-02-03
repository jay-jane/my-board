package com.example.board.controller;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.repository.UserJoinReqDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/signinForm") //회원가입
    public String signInForm(UserJoinReqDTO userJoinReqDTO) {
//        logger.info("user : {}", joinReqDTO.toString());
        userJoinReqDTO.setRole("ROLE_MEMBER");
        String rawPassword = userJoinReqDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinReqDTO.setPassword(encPassword);
        userService.join(userJoinReqDTO);

        return "redirect:/login";
    }

    @PostMapping("/checkId")
    @ResponseBody
    public boolean checkId(@RequestParam(value = "loginId", required = false) String id) {
        logger.info("아이디 중복 검사값 : {}", id);
        boolean result = false;
        if(userService.findByLoginId(id) != null) {
            result = true;
        };

        return result;
    }

    @PostMapping("/checkNickname")
    @ResponseBody
    public int checkNickname(@RequestParam(value = "nickname", required = false) String nickname) {
        logger.info("닉네임 중복 검사값 : {}", nickname);
        return userService.findByNickname(nickname);
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

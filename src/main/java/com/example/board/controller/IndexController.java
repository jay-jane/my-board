package com.example.board.controller;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.repository.BoardListResDto;
import com.example.board.service.board.BoardService;
import com.example.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final UserService userService;

    private final BoardService boardService;

    @GetMapping(value = {"/", "/board"}) //일반, OAuth 로그인 모두 PrincipalDetails에 정보를 담을 수 있음
    public String mainPage(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        if (principalDetails != null) {
            model.addAttribute("nickname", principalDetails.getUserVO().getNickname());
        }
        List<BoardListResDto> boardList = boardService.getBoardContent();
        model.addAttribute("boardList", boardList);
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
    public String boardWrite(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        model.addAttribute("memberId", principalDetails.getUserVO().getId());
        return "board-write";
    }

    @GetMapping("/board/view/{boardId}")
    public String boardView(@PathVariable(value = "boardId", required = false) String boardId, Model model) {
        model.addAttribute("detail", boardService.getBoardDetail(boardId));
        return "board-view";
    }
}

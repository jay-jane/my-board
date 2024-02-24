package com.example.board.controller;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.repository.BoardCountReqDto;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final BoardService boardService;

    @GetMapping(value = {"/", "/board"}) //일반, OAuth 로그인 모두 PrincipalDetails에 정보를 담을 수 있음
    public String boardMain(BoardCountReqDto dto, Pageable pageable, Model model) {
        Page<Map<String, Object>> boardList = boardService.getBoardList(dto, pageable);
        model.addAttribute("boardList", boardList);
        model.addAttribute("dto", dto);
        return "/board/board-main";
    }

    @GetMapping("/login")
    public String logIn(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("error", error);
        return "/user/log-in";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "/user/sign-in";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "/user/my-page";
    }

    @GetMapping("/board/write")
    public String boardWrite(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        model.addAttribute("memberId", principalDetails.getUserVO().getId());
        return "/board/board-write";
    }

    @GetMapping("/board/view/{boardId}")
    public String boardView(@AuthenticationPrincipal PrincipalDetails principalDetails,
                            @PathVariable(value = "boardId", required = false) String boardId,
                            Model model) {

        ResponseEntity<?> result = boardService.getBoardDetail(boardId);
        if(result.getStatusCode() == HttpStatusCode.valueOf(404)) {
            model.addAttribute("message", result.getBody());
            return "/errors/board-404";
        }

        model.addAttribute("detail", result.getBody());
        if (principalDetails != null) {
            model.addAttribute("memberId", principalDetails.getUserVO().getId());
        }
        return "/board/board-view";
    }

    @GetMapping("/board/modify/{boardId}")
    public String boardModify(@PathVariable(value = "boardId", required = false) String boardId, Model model) {
        model.addAttribute("detail", boardService.getBoardDetail(boardId));
        return "/board/board-modi";
    }
}

package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String mainPage() {

        return "board-main";
    }

    @GetMapping(value = {"/", "/log-in"})
    public String logIn() {

        return "log-in";
    }

    @GetMapping("/sign-in")
    public String signIn() {

        return "sign-in";
    }

    @GetMapping("/my-page")
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

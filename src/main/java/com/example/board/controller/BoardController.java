package com.example.board.controller;

import com.example.board.command.TestVO;
import com.example.board.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String mainPage() {

        return "board-main";
    }

    @GetMapping("/log-in")
    public String board() {

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

    @GetMapping("/write")
    public String boardWrite() {
        return "board-write";
    }
}

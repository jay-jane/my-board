package com.example.board.controller;

import com.example.board.controller.IndexController;
import com.example.board.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final UserService userService;

    @PostMapping("/join")
    public String join(HttpServletRequest request) {
        String loginId = request.getParameter("loginId");
        logger.info("loginId : {}", loginId);
        return "redirect:/login";
    }

}

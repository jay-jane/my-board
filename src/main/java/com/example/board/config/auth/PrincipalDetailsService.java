package com.example.board.config.auth;

import com.example.board.controller.IndexController;
import com.example.board.repository.UserVO;
import com.example.board.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    public UserService userService;

    @Override //Security Session(안에 Authentication(안에 UserDetails))
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username : {}", username);
        UserVO userEntity = userService.findByUsername(username);

        if(userEntity != null) {
            return new PrincipalDetails(userEntity); //PrincipalDetails 객체를 리턴 받기 위해 오버라이드 한 것
        }
        return null;
    }
}

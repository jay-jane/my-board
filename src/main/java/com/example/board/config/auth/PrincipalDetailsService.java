package com.example.board.config.auth;

import com.example.board.repository.user.UserVO;
import com.example.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(PrincipalDetailsService.class);

    private final UserService userService;

    @Override //Security Session(안에 Authentication(안에 UserDetails))
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        UserVO userEntity = userService.findByLoginId(loginId);

        if(userEntity != null) {
            return new PrincipalDetails(userEntity); //PrincipalDetails 객체를 리턴 받기 위해 오버라이드 한 것
        }
        return null;
    }
}

package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDTO;
import com.example.board.repository.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    public int join(UserJoinReqDTO userJoinReqDTO);

    public UserVO findByLoginId(String loginId);

    public boolean checkLoginId(String loginId);

    public boolean checkNickname(String nickname);

    public Map<String, String> validateHandling(Errors errors);
}

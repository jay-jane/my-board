package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDto;
import com.example.board.repository.UserJoinResDto;
import com.example.board.repository.UserModiReqDto;
import com.example.board.repository.UserVO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    public UserJoinResDto join(UserJoinReqDto userJoinReqDTO);

    public int modifyUser(UserModiReqDto reqDto);

    public int modifyPassword(UserModiReqDto reqDto);

    public int deleteUser(UserModiReqDto reqDto);

    public UserVO findByLoginId(String loginId);

    public boolean checkLoginId(String loginId);

    public boolean checkNickname(String nickname);

    public boolean checkPassword(String id, String newPassword);

    public Map<String, String> validateHandling(Errors errors);
}

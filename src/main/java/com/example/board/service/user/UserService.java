package com.example.board.service.user;

import com.example.board.repository.user.UserJoinReqDto;
import com.example.board.repository.user.UserJoinResDto;
import com.example.board.repository.user.UserModiReqDto;
import com.example.board.repository.user.UserVO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    public UserJoinResDto join(UserJoinReqDto userJoinReqDTO);

    public int modifyUser(UserModiReqDto reqDto);

    public int modifyPassword(UserModiReqDto reqDto);

    public int deleteUser(long id);

    public UserVO findByLoginId(String loginId);

    public boolean checkLoginId(String loginId);

    public boolean checkNickname(String nickname);

    public boolean checkPassword(long id, String newPassword);

    public Map<String, String> validateHandling(Errors errors);
}

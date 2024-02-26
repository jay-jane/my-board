package com.example.board.service.user;

import com.example.board.repository.user.UserJoinReqDto;
import com.example.board.repository.user.UserJoinResDto;
import com.example.board.repository.user.UserModiReqDto;
import com.example.board.repository.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserJoinResDto join(UserJoinReqDto userJoinReqDto) {
        userJoinReqDto.setRole("ROLE_MEMBER");
        String rawPassword = userJoinReqDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinReqDto.setPassword(encPassword);

        String id = userJoinReqDto.getLoginId();

        if (userMapper.join(userJoinReqDto) == 1) {
            UserVO vo = findByLoginId(id);
            return new UserJoinResDto(vo.getNickname(), vo.getRole(), "회원가입 성공");
        }
        return new UserJoinResDto("회원가입 실패");
    }

    @Override
    public int modifyUser(UserModiReqDto reqDto) {
        return userMapper.modifyUser(reqDto);
    }

    @Override
    public int modifyPassword(UserModiReqDto reqDto) {
        String rawPassword = reqDto.getNewPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        reqDto.setNewPassword(encPassword);
        return userMapper.modifyPassword(reqDto);
    }

    @Override
    public int deleteUser(long id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public UserVO findByLoginId(String loginId) {
        return userMapper.findByLoginId(loginId);
    }

    @Override
    public boolean checkLoginId(String loginId) {
        return userMapper.findByLoginId(loginId) != null;
    }

    @Override
    public boolean checkNickname(String nickname) {
        return userMapper.checkNickname(nickname);
    }

    @Override
    public boolean checkPassword(long id, String password) {
        String originalPassword = userMapper.checkPassword(id);
        return BCrypt.checkpw(password, originalPassword);
    }

    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> result = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKey = String.format("valid_%s", error.getField());
            result.put(validKey, error.getDefaultMessage());
        }
        return result;
    }
}

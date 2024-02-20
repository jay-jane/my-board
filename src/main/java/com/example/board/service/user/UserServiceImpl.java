package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDto;
import com.example.board.repository.UserJoinResDto;
import com.example.board.repository.UserModiReqDto;
import com.example.board.repository.UserVO;
import lombok.RequiredArgsConstructor;
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

    @Override
    public UserJoinResDto join(UserJoinReqDto userJoinReqDTO) {
        userJoinReqDTO.setRole("ROLE_MEMBER");
        String rawPassword = userJoinReqDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinReqDTO.setPassword(encPassword);

        String id = userJoinReqDTO.getLoginId();

        if(userMapper.join(userJoinReqDTO) == 1) {
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
    public UserVO findByLoginId(String loginId) {
        return userMapper.findByLoginId(loginId);
    }

    @Override
    public boolean checkLoginId(String loginId) {
        boolean result = false;
        if (userMapper.findByLoginId(loginId) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean checkNickname(String nickname) {
        return userMapper.checkNickname(nickname);
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

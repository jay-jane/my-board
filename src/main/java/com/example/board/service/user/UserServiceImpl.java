package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDTO;
import com.example.board.repository.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public int join(UserJoinReqDTO userJoinReqDTO) {
        return userMapper.join(userJoinReqDTO);
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
}

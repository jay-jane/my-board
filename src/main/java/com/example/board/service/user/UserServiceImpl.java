package com.example.board.service.user;

import com.example.board.repository.JoinReqDTO;
import com.example.board.repository.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int join(JoinReqDTO joinReqDTO) {
        return userMapper.join(joinReqDTO);
    }

    @Override
    public UserVO findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

}

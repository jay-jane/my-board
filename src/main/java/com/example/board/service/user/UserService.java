package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDTO;
import com.example.board.repository.UserVO;

public interface UserService {

    public int join(UserJoinReqDTO userJoinReqDTO);

    public UserVO findByLoginId(String loginId);

    public int findByNickname(String nickname);
}

package com.example.board.service.user;

import com.example.board.repository.JoinReqDTO;
import com.example.board.repository.UserVO;

public interface UserService {

    public int join(JoinReqDTO joinReqDTO);

    public UserVO findByLoginId(String loginId);

    public int findByNickname(String nickname);
}

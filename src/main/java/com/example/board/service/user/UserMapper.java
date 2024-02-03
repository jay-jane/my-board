package com.example.board.service.user;

import com.example.board.repository.JoinReqDTO;
import com.example.board.repository.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int join(JoinReqDTO joinReqDTO);

    public UserVO findByLoginId(String loginId);

    public int findByNickname(String nickname);
}

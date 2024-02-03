package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDTO;
import com.example.board.repository.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int join(UserJoinReqDTO userJoinReqDTO);

    public UserVO findByLoginId(String loginId);

    public int findByNickname(String nickname);
}

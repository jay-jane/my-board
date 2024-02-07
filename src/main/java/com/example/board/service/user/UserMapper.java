package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDto;
import com.example.board.repository.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int join(UserJoinReqDto userJoinReqDTO);

    public UserVO findByLoginId(String loginId);

    public boolean checkNickname(String nickname);
}

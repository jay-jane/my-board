package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDto;
import com.example.board.repository.UserModiReqDto;
import com.example.board.repository.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int join(UserJoinReqDto userJoinReqDTO);

    public int modifyUser(UserModiReqDto reqDto);

    public int modifyPassword(UserModiReqDto reqDto);

    public int deleteUser(UserModiReqDto reqDto);

    public UserVO findByLoginId(String loginId);

    public boolean checkNickname(String nickname);

    public String checkPassword(String id);
}

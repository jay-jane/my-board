package com.example.board.service.user;

import com.example.board.repository.UserJoinReqDTO;
import com.example.board.repository.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper
public interface UserMapper {

    public int join(UserJoinReqDTO userJoinReqDTO);

    public UserVO findByLoginId(String loginId);

    public boolean checkNickname(String nickname);
}

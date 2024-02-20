package com.example.board.repository;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModiReqDto {
    private String id;
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9]{2,13}$", message = "닉네임은 특수문자를 제외한 2~13자리여야 합니다")
    private String nickname;
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "010-0000-0000 또는 01012341234 형식으로 입력해 주세요")
    private String phone;
}

package com.example.board.repository.user;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModiReqDto {
    private String id;
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9]{2,13}$", message = "닉네임은 특수문자를 제외한 2~13자리여야 합니다")
    private String nickname;
    @Pattern(regexp = "^010-?([0-9]{4})-?([0-9]{4})$", message = "010-0000-0000 또는 01012341234 형식으로 입력해 주세요")
    private String phone;

    private String password;
    @Pattern(regexp = "^[a-zA-Z0-9]{6,15}$", message = "비밀번호는 알파벳 대소문자와 숫자만 입력 가능합니다 (6~15자리)")
    private String newPassword;
}

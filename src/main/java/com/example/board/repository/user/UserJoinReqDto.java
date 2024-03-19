package com.example.board.repository.user;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserJoinReqDto {
    @NotBlank(message = "아이디는 필수 입력 항목입니다")
    @Pattern(regexp = "^[a-z0-9]{6,12}$", message = "아이디는 영어 소문자와 숫자만 입력 가능합니다 (6~12자리)")
    private String loginId;
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,15}$", message = "비밀번호는 알파벳 대소문자와 숫자만 입력 가능합니다 (6~15자리)")
    private String password;
    @NotBlank(message = "이름은 필수 입력 항목입니다")
    @Size(min = 2, max = 10, message = "이름은 2~10자까지 입력하실 수 있습니다")
    private String name;
    @NotBlank(message = "닉네임은 필수 입력 항목입니다")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9]{2,13}$", message = "닉네임은 특수문자를 제외한 2~13자리여야 합니다")
    private String nickname;
    @Past(message = "과거 날짜만 입력하실 수 있습니다")
    private LocalDate birth;
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "010-0000-0000 또는 01012341234 형식으로 입력해 주세요")
    private String phone;
    @Email(message = "이메일 형식이 아닙니다. xxx@xxx.xxx 형식으로 입력해 주세요")
    private String email;
    private String role;
    private String provider;
    private String providerId;
}

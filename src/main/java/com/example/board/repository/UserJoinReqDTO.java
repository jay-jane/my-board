package com.example.board.repository;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserJoinReqDTO {
    @Size(min = 1, max = 12, message = "아이디는 1~12 글자여야 합니다")
    @Pattern(regexp = "^[a-zA-Z0-0]*$", message = "아이디는 영어와 숫자만 가능합니다.")
    private String loginId;
    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-0]*$", message = "비밀번호는 영어와 숫자만 가능합니다.")
    private String password;
    @Size(min = 1, max = 20, message = "이름은 최대 10자까지 입력하실 수 있습니다")
    private String name;
    @NotBlank(message = "이름을 입력해 주세요")
    private String nickname;
    @Past(message = "과거 날짜만 입력하실 수 있습니다")
    private LocalDate birth;
    @Size(max = 13, message = "-(하이픈) 제외 010 포함 핸드폰 번호를 입력해 주세요")
    private String phone;
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    private String role;
    private String provider;
    private String provider_id;
}

package com.example.board.config.auth;

import com.example.board.repository.user.UserVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

//시큐리티가 /login 주소 요청을 가로채서 로그인을 진행시킨다.
//진행이 완료되면 시큐리티 session을 만들어 줌(Security ContextHolder)
//오브젝트 > Authentication 타입 객체
//Authentication 안에 User 정보가 있어야 함 > User 오브젝트의 타입 > UserDetails 타입 객체
//Security Session > Authentication > UserDetails(PrincipalDetails)
@Getter
@NoArgsConstructor
public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserVO userVO;
    private Map<String, Object> attributes;

    public PrincipalDetails(UserVO userVO) { //일반 로그인 생성자
        this.userVO = userVO;
    }
    public PrincipalDetails(UserVO userVO, Map<String, Object> attributes) { //OAuth 로그인 생성자
        this.userVO = userVO;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userVO.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userVO.getPassword();
    }

    @Override
    public String getUsername() {
        return userVO.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //* 휴면 계정 처리 방법
        //내 사이트에서 1년 동안 로그인을 안 할 시 휴먼 처리를 하기로 했을 때
        //테이블에서 로그인데이트 값을 받아와서
        //현재 시간 - 로그인 시간 = 1년을 초과하면 return false로 변경
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}

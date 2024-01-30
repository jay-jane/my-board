package com.example.board.config;

import com.example.board.config.oauth.PrincipalOauth2UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration //클래스를 구성 클래스로 표시
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록됨
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//secured, preAuthorize, postAuthorize 어노테이션 활성화
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    //WebSecurityConfigurerAdapter는 deprecated 됨
    //기존의 configure 메서드가 아닌 filterChain 메서드로 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/board/write").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_MANAGER')")
                .requestMatchers("/mypage").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_MANAGER')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginForm") //주소가 호출 되면 시큐리티가 낚아 채서 대신 로그인 진행
                .defaultSuccessUrl("/board")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        //소셜(구글) 로그인 완료 - 후 처리 필요 - 코드x, 액세스 토큰과 사용자 정보를 받음
        //코드받기(인증) > 액세스토큰(권한) > 사용자 프로필 접근 (자동 회원가입 진행 가능)

        //로그아웃 처리
        http.logout()
                .logoutUrl("/logout")
                .addLogoutHandler((request, response, authentication) -> {
                    HttpSession session = request.getSession();
                    if (session != null) {
                        session.invalidate();
                    }
                })
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.sendRedirect("/login");
                })
                .deleteCookies("JSESSIONID");

        return http.build();
    }
}

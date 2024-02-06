package com.example.board.config;

import com.example.board.config.auth.FailureHandler;
import com.example.board.config.oauth.PrincipalOauth2UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;


@Configuration //클래스를 구성 클래스로 표시
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록됨
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
//secured, preAuthorize, postAuthorize 어노테이션 활성화
public class WebSecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;

    private final FailureHandler failureHandler;

    //WebSecurityConfigurerAdapter는 deprecated 됨
    //기존의 configure 메서드가 아닌 filterChain 메서드로 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource());
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/board/write").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_MANAGER')")
                .requestMatchers("/mypage").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_MANAGER')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login") //사용자 정의 로그인 페이지
                .failureHandler(failureHandler)
                .loginProcessingUrl("/loginForm") //주소가 호출 되면 시큐리티가 낚아 채서 대신 로그인 진행
                .defaultSuccessUrl("/board") //로그인 성공 후 이동 페이지
                .usernameParameter("loginId") //username(아이디)를 내가 설정한 값으로 지정
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

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.addAllowedHeader("**");
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

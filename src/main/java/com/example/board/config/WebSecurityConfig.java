package com.example.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//클래스를 구성 클래스로 표시
@Configuration
public class WebSecurityConfig {

    //반환된 값을 스프링 컨텍스트에 빈으로 추가하도록 지시
    @Bean
    public UserDetailsService userDetailsService() {
        //var는 구문을 간소하게 만들어주고 세부 정보를 감춘다
        var userDetailsService = new InMemoryUserDetailsManager();

        //이름, 암호, 권한 목록으로 사용자 생성
        var user = User.withUsername("jane")
                .password("1234")
                .authorities("read")
                .build();

        //userDetailsService에서 관리하도록 사용자 추가
        userDetailsService.createUser(user);

        return userDetailsService;
    }

    //PasswordEncoder를 컨텍스트에 추가
    @Bean
    public PasswordEncoder passwordEncoder() {

        //NoOpPasswordEncoder 인스턴스는 암호화나 해시를 적용하지 않고 일반 텍스트처럼 처리하기 때문에
        //운영 단계에는 적합하지 않음(테스트 용도)
        return NoOpPasswordEncoder.getInstance();
    }

    //WebSecurityConfigurerAdapter는 deprecated 됨
    //기존의 configure 메서드가 아닌 filterChain 메서드로 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults());
        http.authorizeRequests()
                .anyRequest().authenticated(); //다시 해 보기

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain2(AuthenticationManagerBuilder auth) throws Exception {
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        var user = User.withUsername("jay")
//                .password("1234")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//    }
}

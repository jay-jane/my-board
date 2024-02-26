package com.example.board.config.oauth;

import com.example.board.config.auth.PrincipalDetails;
import com.example.board.config.oauth.provider.GoogleUserInfo;
import com.example.board.config.oauth.provider.KakaoUserInfo;
import com.example.board.config.oauth.provider.OAuth2UserInfo;
import com.example.board.repository.user.UserJoinReqDto;
import com.example.board.repository.user.UserVO;
import com.example.board.service.user.UserService;
import com.example.board.util.Namer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

//해당 메서드 종료 시 @AuthenticationPrincipal 어노테이션이 생성됨
@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private static final Logger logger = LoggerFactory.getLogger(PrincipalOauth2UserService.class);

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserService userService;

    private OAuth2UserInfo oAuth2UserInfo;

    @Override //소셜(구글, 카카오) 로그인 진행 후 후처리 되는 메서드 - 구글로부터 받은 userRequest 데이터 처리
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        logger.info("ClientRegistration : {}", userRequest.getClientRegistration());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        //구글/카카오 로그인 버튼 클릭 > 구글/카카오 로그인 창 > 로그인 완료 > code 리턴(oauth2라이브러리) > AccessToken 요청
        //userRequest 정보 받음 > loadUser 메서드 호출 > 구글/카카오로부터 회원 프로필 받음
        logger.info("Attributes : {}", oAuth2User.getAttributes());
        //회원가입 진행
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            logger.info("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
            logger.info("카카오 로그인 요청");
            oAuth2UserInfo = new KakaoUserInfo((oAuth2User.getAttributes()));
        } else {
            logger.info("구글, 카카오 로그인만 지원");
        }

        String provider = oAuth2UserInfo.getProvider(); //google or kakao
        String providerId = oAuth2UserInfo.getProviderId();
        String loginId = provider + "_" + providerId; //google_########### or kakao_###########
        String password = bCryptPasswordEncoder.encode("의미없는");
        String name = oAuth2UserInfo.getName();
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_MEMBER";

        UserVO userEntity = userService.findByLoginId(loginId);
        //login_id, password, name, nickname, birth, phone, email, provider, provider_id, role
        if (userEntity == null) {
            logger.info("최초 로그인, 자동 회원가입 진행");
            UserJoinReqDto userJoinReqDTO = new UserJoinReqDto();
            Namer namer = new Namer();
            userJoinReqDTO.setLoginId(loginId);
            userJoinReqDTO.setPassword(password);
            userJoinReqDTO.setName(name);
            userJoinReqDTO.setNickname(namer.getRandomNickname());
            userJoinReqDTO.setEmail(email);
            userJoinReqDTO.setRole(role);
            userJoinReqDTO.setProvider(provider);
            userJoinReqDTO.setProviderId(providerId);
            userService.join(userJoinReqDTO);
            userEntity = userService.findByLoginId(loginId);
        } else {
            logger.info("구글/카카오 로그인 등록 회원");
        }

        //PrincipalDetails 객체를 리턴 받기 위해 오버라이드 한 것
        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}

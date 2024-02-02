package com.example.board.config.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes; //oauth2User.getAttributes()
    private Map<String, String> kakaoEmail;
    private Map<String, String> kakaoName;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoEmail = (Map<String, String>) attributes.get("kakao_account");
        this.kakaoName = (Map<String, String>) attributes.get("properties");
    }

    //attributes :
    //{
    // id=3324476174,
    // connected_at=2024-02-01T13:23:50Z,
    //  properties={nickname=이재윤},
    //  kakao_account=
    //      {profile_nickname_needs_agreement=false,
    //      profile_image_needs_agreement=true,
    //      profile={nickname=이재윤},
    //      has_email=true,
    //      email_needs_agreement=false,
    //      is_email_valid=true,
    //      is_email_verified=true,
    //      email=sk22345@naver.com}
    // }
    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public String getEmail() {
        return String.valueOf(kakaoEmail.get("email"));
    }

    @Override
    public String getName() {
        return String.valueOf(kakaoName.get("nickname"));
    }
}

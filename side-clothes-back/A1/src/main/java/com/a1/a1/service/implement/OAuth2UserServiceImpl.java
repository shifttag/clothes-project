package com.a1.a1.service.implement;

import com.a1.a1.common.util.CustomOAuth2User;
import com.a1.a1.entity.UserEntity;
import com.a1.a1.provider.JwtProvider;
import com.a1.a1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registration = userRequest.getClientRegistration().getClientName().toLowerCase();

        String snsId = getSnsId(oAuth2User, registration);

        UserEntity user = userRepository.findBySnsIdAndJoinPath(snsId, registration);

        CustomOAuth2User customOAuth2User = null;

        if(user == null) {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("snsId", snsId);
            attributes.put("joinPath", registration);

            customOAuth2User = new CustomOAuth2User(snsId, attributes, false);
        } else {
            String userId = user.getUserId();
            String token = jwtProvider.generateToken(userId);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("accessToken", token);

            customOAuth2User = new CustomOAuth2User(userId, attributes, true);
        }
        return customOAuth2User;
    }

    private String getSnsId(OAuth2User oAuth2User, String registration) {
        String snsId = null;

        if(registration.equals("kakao")) {
            snsId = oAuth2User.getName();
        }
        if(registration.equals("naver")) {
            Map<String, String> response = (Map<String, String>) oAuth2User.getAttributes().get("response");
            snsId = response.get("id");
        }
        return snsId;
    }


}

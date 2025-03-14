package com.a1.a1.handler;

import com.a1.a1.common.util.CustomOAuth2User;
import com.a1.a1.entity.UserEntity;
import com.a1.a1.provider.JwtProvider;
import com.a1.a1.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = customOAuth2User.getAttributes();
        boolean existed = customOAuth2User.isExisted();

        if(existed){
            Optional<UserEntity> optionalUser = userRepository.findByUserId(customOAuth2User.getName());
            UserEntity user = null;
            String accessToken = null;
            if(optionalUser.isPresent()){
                user = optionalUser.get();
            }
            if(user != null){
                accessToken = jwtProvider.generateToken(user.getUserId());
            }
            int expireTime = jwtProvider.getExpiration();
            response.sendRedirect("http://localhost:3000/sns-success?acessToken=" + accessToken + "&expireTime=" + expireTime);
        } else {
            String snsId = (String) attributes.get("snsId");
            String joinPath = (String) attributes.get("joinPath");
            System.out.println("snsId: " + snsId);
            System.out.println("joinPath: " + joinPath);
            response.sendRedirect("http://localhost:3000/auth?snsId=" + snsId + "&joinPath=" + joinPath);
        }
    }
}

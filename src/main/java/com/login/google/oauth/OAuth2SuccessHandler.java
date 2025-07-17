package com.login.google.oauth;


import com.login.google.domain.UserRepository;
import com.login.google.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // 1. 인증된 사용자 정보 가져오기
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        // 2. JWT 발급
        String token = jwtTokenProvider.createToken(oAuth2User.getUser().getEmail());

        log.info("로그인 성공 - JWT 발급: {}", token);

        // 3. 프론트로 리다이렉트 (토큰 포함해서 보내기)
        response.sendRedirect("http://localhost:3000/oauth2/success?token=" + token);
    }

}

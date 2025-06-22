package com.example.graduation_work_BE.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 🔓 테스트를 위한 특정 경로 허용
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/test-login/**",       // 테스트용 로그인 엔드포인트
                                "/user/**",             // 사용자 정보 조회
                                "/study/group/**",// 스터디 그룹 조회 등 테스트용
                                "/comment/**",
                                "/company/**",
                                "/job/posting/**",
                                "/openai/**",
                                "/posting/**",
                                "/user/target/**",
                                "/resume/**",
                                "/study/group/**",
                                "/study/participant/**",
                                "/user/schedule/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                // ✅ OAuth2 로그인 (구글 등)
                .oauth2Login(Customizer.withDefaults())
                // 🚫 CSRF 끔 (Postman 사용 시 필수)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

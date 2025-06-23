package com.example.graduation_work_BE.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // ✅ 꼭 추가
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/main/user").permitAll()
                        .requestMatchers(HttpMethod.POST, "/main/user").permitAll()
                        .requestMatchers(HttpMethod.POST, "/main/auth/**").permitAll()
                        .requestMatchers(
                                "/test-login/**",
                                "/user/**",
                                "/study/group/**",
                                "/comment/**",
                                "/company/**",
                                "/job/posting/**",
                                "/openai/**",
                                "/posting/**",
                                "/user/target/**",
                                "/resume/**",
                                "/study/participant/**",
                                "/user/schedule/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:8080",
                "http://localhost:5173",
                "http://3.34.45.188"
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

package com.example.graduation_work_BE.openai.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openai")
public class OpenAiConfig {
    private String apiKey;
    private String model;
    private Double temperature;
    private Integer maxTokens;
}
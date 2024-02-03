package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //url 패턴
                .allowedOrigins("*") //http://127.0.0.1:5500
                .allowedMethods("GET", "POST") // "PUT", "DELETE"
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}

package com.project.sundo_project.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    private String[] urls = {
            "http://localhost:8000",
            "http://localhost:8080",
            "http://192.168.35.41:8000"
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("/**")
                .allowedOrigins(urls)
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}

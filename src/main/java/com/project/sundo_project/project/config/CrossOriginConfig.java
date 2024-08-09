package com.project.sundo_project.project.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CrossOriginConfig implements WebMvcConfigurer {
    private String[] urls = {
            "http://localhost:8000"
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("/**")
                .allowedOrigins(urls)
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
        ;
    }

}

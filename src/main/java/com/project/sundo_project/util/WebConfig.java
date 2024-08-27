package com.project.sundo_project.util;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.MULTIPART_FORM_DATA)
                .mediaType("octet-stream", MediaType.APPLICATION_OCTET_STREAM);
    }
}
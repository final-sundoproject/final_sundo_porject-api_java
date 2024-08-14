package com.project.sundo_project.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public SecretKey jwtSecretKey() {
        // HS256 알고리즘에 적합한 SecretKey를 자동으로 생성
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    @Bean
    public long jwtExpirationTime() {
        // JWT 만료 시간을 반환
        return 3600000; // 1시간
    }
}

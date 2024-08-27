package com.project.sundo_project.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirationTime;

    @Autowired
    public JwtUtil(SecretKey secretKey, long expirationTime) {
        this.secretKey = secretKey;
        this.expirationTime = expirationTime;
    }

    // JWT 토큰 생성 - companyCode 포함
    public String generateToken(String email, Long companyCode) {
        return Jwts.builder()
                .setSubject(email)
                .claim("companyCode", companyCode)  // companyCode 추가
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
    }

    // JWT 토큰 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 토큰에서 사용자 이메일 추출
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    // 토큰에서 companyCode 추출
    public Long getCompanyCodeFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claims.get("companyCode", Long.class);
    }

    public boolean isTokenValid(String token) {
        try {
            // 토큰에서 클레임을 파싱하여 토큰이 유효한지 확인합니다.
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            // 토큰의 만료 시간을 확인합니다.
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            // 서명 오류 또는 만료된 토큰의 경우 false를 반환합니다.
            return false;
        }
    }
}

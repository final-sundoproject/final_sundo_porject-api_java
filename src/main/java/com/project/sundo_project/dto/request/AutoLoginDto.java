package com.project.sundo_project.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class AutoLoginDto {
    private String sessionId; // 자동로그인 쿠키값
    private LocalDateTime limitTime; // 만료시간
    private String companyEmail; // 계정명

}

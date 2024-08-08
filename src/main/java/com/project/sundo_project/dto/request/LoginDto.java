package com.project.sundo_project.dto.request;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class LoginDto {

    private String companyEmail;
    private String password;
    private boolean autoLogin; // 자동로그인 체크 여부
}

package com.project.sundo_project.entity;

/*
CREATE TABLE Company (
CompanyEmail VARCHAR(255),
Password VARCHAR(255) NOT NULL,
CompanyName VARCHAR(255) NOT NULL,
CompanyAddress VARCHAR(255) NOT NULL,
BusinessNumber VARCHAR(20) NOT NULL,
RegistrationDate DATETIME NOT NULL,
CompanyCode INT AUTO_INCREMENT PRIMARY KEY
);
-- 배포시 삭제 예정
 */

import lombok.*;

import java.time.LocalDateTime;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    private String companyEmail;
    // @Setter
    private String password;
    private String companyName;
    private String companyAddress;
    private String businessNumber;
    private LocalDateTime registrationDate;
    private int companyCode;

    private LocalDateTime limitTime;

}

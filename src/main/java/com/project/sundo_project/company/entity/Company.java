package com.project.sundo_project.company.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 설정
    @Column(name = "company_code")
    private Long companyCode;  // 타입을 Long으로 변경


    @Column(name = "company_email", nullable = false, unique = true)
    private String companyEmail;

    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_address", nullable = false)
    private String companyAddress;

    @Column(name = "business_number", nullable = false)
    private String businessNumber;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @PrePersist
    public void prePersist() {
        this.registrationDate = LocalDateTime.now();
    }

    // 세션 관련 필드
    private String sessionId;
    private LocalDateTime limitTime;
}

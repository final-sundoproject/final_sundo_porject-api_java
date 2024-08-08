package com.project.sundo_project.dto.response;

import com.project.sundo_project.entity.Company;
import lombok.*;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserInfoDto {

    // 클라이언트에 보낼 정보
    private String companyEmail;
    private String companyName;
    private String companyAddress;
    private String businessNumber;
    private int companyCode;

    // 생성자
    public LoginUserInfoDto (Company company) {
        this.companyEmail = company.getCompanyName();
        this.companyName = company.getCompanyName();
        this.companyAddress = company.getCompanyAddress();
        this.businessNumber = company.getBusinessNumber();
        this.companyCode = company.getCompanyCode();

    }



}

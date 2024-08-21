package com.project.sundo_project.company.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordFindRequest {
    private String companyEmail;
    private String companyName;
    private String companyAddress;
    private String businessNumber;
}

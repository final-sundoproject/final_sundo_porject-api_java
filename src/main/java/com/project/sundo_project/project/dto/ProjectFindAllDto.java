package com.project.sundo_project.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFindAllDto {

    private String projectName;
    private LocalDateTime registrationDate;
    private Long companyCode;  // int에서 Long으로 변경
    private Long projectId;     // int에서 Long으로 변경
}

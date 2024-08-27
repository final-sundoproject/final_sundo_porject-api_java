package com.project.sundo_project.project.repository;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {  // Integer에서 Long으로 변경

    @Query("SELECT new com.project.sundo_project.project.dto.ProjectFindAllDto(p.projectName, p.registrationDate, p.companyCode, p.projectId) FROM Project p WHERE p.companyCode = :companyCode")
    List<ProjectFindAllDto> findAllByCompanyCode(@Param("companyCode") Long companyCode);  // long에서 Long으로 변경
}

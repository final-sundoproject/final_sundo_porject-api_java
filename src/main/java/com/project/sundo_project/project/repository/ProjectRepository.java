package com.project.sundo_project.project.repository;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new com.project.sundo_project.project.dto.ProjectFindAllDto(p.projectName, p.registrationDate) FROM Project p WHERE p.companyCode = :companyCode")
    List<ProjectFindAllDto> findAllByCompanyCode(@Param("companyCode") int companyCode);
}

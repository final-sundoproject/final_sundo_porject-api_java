package com.project.sundo_project.project.service;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import com.project.sundo_project.project.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectFindAllDto> findAllProjectsByCompanyCode(Long companyCode) {  // int에서 Long으로 변경
        return projectRepository.findAllByCompanyCode(companyCode);
    }

    public Project saveProject(Project project) {
        project.setRegistrationDate(LocalDateTime.now());
        Project savedProject = projectRepository.save(project);
        log.info("Project saved: {}", savedProject);
        return savedProject;
    }

    public boolean deleteProject(Long id) {  // int에서 Long으로 변경
        return projectRepository.findById(id)
                .map(project -> {
                    projectRepository.deleteById(id);
                    log.info("Project deleted: {}", project);
                    return true;
                })
                .orElse(false);
    }

    public Project findProjectById(Long id) {  // int에서 Long으로 변경
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProject(Long id, Project projectDetails) {  // int에서 Long으로 변경
        return projectRepository.findById(id)
                .map(project -> {
                    project.setProjectName(projectDetails.getProjectName());
                    project.setCompanyCode(projectDetails.getCompanyCode());
                    project.setRegistrationDate(LocalDateTime.now());  // 업데이트할 때 날짜 갱신
                    Project updatedProject = projectRepository.save(project);
                    log.info("Project updated: {}", updatedProject);
                    return updatedProject;
                })
                .orElse(null);
    }
}

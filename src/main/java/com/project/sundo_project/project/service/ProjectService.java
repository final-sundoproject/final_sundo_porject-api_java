package com.project.sundo_project.project.service;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import com.project.sundo_project.project.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectFindAllDto> findAllProjectsByCompanyCode(int companyCode) {
        return projectRepository.findAllByCompanyCode(companyCode);
    }

    public Project saveProject(Project project) {
        project.setRegistrationDate(LocalDateTime.now());
        Project save = projectRepository.save(project);
        return save;
    }


    public boolean deleteProject(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

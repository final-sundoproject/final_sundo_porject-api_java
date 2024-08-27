package com.project.sundo_project.project.controller;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import com.project.sundo_project.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // 모든 프로젝트 조회 (특정 회사 코드에 따라)
    @GetMapping
    public ResponseEntity<List<ProjectFindAllDto>> getProjectsByCompanyCode(@RequestParam Long companyCode) {  // int에서 Long으로 변경
        List<ProjectFindAllDto> projects = projectService.findAllProjectsByCompanyCode(companyCode);
        if (projects.isEmpty()) {
            log.info("No projects found for companyCode: {}", companyCode);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projects);
    }

    // 프로젝트 ID로 단일 프로젝트 조회
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {  // int에서 Long으로 변경
        Optional<Project> project = Optional.ofNullable(projectService.findProjectById(id));
        return project.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Project with id {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // 새 프로젝트 생성
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        log.info("Created project: {}", savedProject);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProject.getProjectId())
                .toUri();

        return ResponseEntity.created(location).body(savedProject);
    }

    // 프로젝트 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {  // int에서 Long으로 변경
        Optional<Project> updatedProject = Optional.ofNullable(projectService.updateProject(id, project));
        return updatedProject.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Failed to update project with id {}. Project not found.", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // 프로젝트 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {  // int에서 Long으로 변경
        boolean isDeleted = projectService.deleteProject(id);
        if (isDeleted) {
            log.info("Deleted project with id: {}", id);
            return ResponseEntity.ok().build();
        } else {
            log.warn("Failed to delete project with id {}. Project not found.", id);
            return ResponseEntity.notFound().build();
        }
    }
}

package com.project.sundo_project.project.controller;

import com.project.sundo_project.project.dto.ProjectFindAllDto;
import com.project.sundo_project.project.entity.Project;
import com.project.sundo_project.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // 모든 프로젝트 조회 (특정 회사 코드에 따라)
    @GetMapping
    public ResponseEntity<List<ProjectFindAllDto>> getProjectsByCompanyCode(@RequestParam int companyCode) {
        List<ProjectFindAllDto> projects = projectService.findAllProjectsByCompanyCode(companyCode);
        if (projects.isEmpty()) {
            return ResponseEntity.noContent().build(); // 내용이 없을 경우 No Content 상태 반환
        }
        return ResponseEntity.ok(projects);
    }

//    // 프로젝트 ID로 단일 프로젝트 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
//        Project project = projectService.findProjectById(id);
//        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
//    }
//
    // 새 프로젝트 생성
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        log.info("project:{}", project);
        return ResponseEntity.created(URI.create("/api/projects/" + savedProject.getProjectId())).body(savedProject);
    }

//    // 프로젝트 업데이트
//    @PutMapping("/{id}")
//    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
//        Project updatedProject = projectService.updateProject(id, project);
//        return updatedProject != null ? ResponseEntity.ok(updatedProject) : ResponseEntity.notFound().build();
//    }
//
    // 프로젝트 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        boolean isDeleted = projectService.deleteProject(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
package com.project.sundo_project.controller;

import com.project.sundo_project.dto.request.EvaluationSaveDto;
import com.project.sundo_project.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody EvaluationSaveDto dto) {
        log.info("Received DTO: {}", dto);
        evaluationService.save(dto);
        return ResponseEntity.ok("Evaluation saved!");
    }
}

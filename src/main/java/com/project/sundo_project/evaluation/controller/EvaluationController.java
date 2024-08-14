package com.project.sundo_project.evaluation.controller;

import com.project.sundo_project.evaluation.dto.request.EvaluationSaveDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindAllDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindDto;
import com.project.sundo_project.evaluation.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> register(
            @RequestPart(value = "arImage") MultipartFile uploadFile,
            @RequestPart(value = "title") String title,
            @RequestPart(value = "registrantName") String registrantName,
            @RequestPart(value = "windVolume") int windVolume,
            @RequestPart(value = "noiseLevel") int noiseLevel,
            @RequestPart(value = "scenery") int scenery,
            @RequestPart(value = "waterDepth") int waterDepth) throws IOException {

        EvaluationSaveDto dto = new EvaluationSaveDto(title, registrantName, windVolume, noiseLevel, scenery, waterDepth);

        log.info("uploadFile: {}", uploadFile);
        log.info("dto: {}", dto);

        evaluationService.save(uploadFile,dto);

        return ResponseEntity.ok("Evaluation saved!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("Deleting Evaluation with ID: {}", id);
        evaluationService.deleteById(id);
        return ResponseEntity.ok().body("Evaluation deleted!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modify(
            @RequestBody EvaluationSaveDto dto,
            @PathVariable Long id
    ) {
        log.info("modify evaluation: {}" , dto );
        log.info("modify evaluation id : {}" , id );

        evaluationService.modify(dto, id);

        return ResponseEntity.ok().body("evaluation modified!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvaluation(@PathVariable Long id){
        EvaluationFindDto foundOne = evaluationService.findById(id);
        log.info("foundOne: {}", foundOne);

        return ResponseEntity.ok().body(foundOne);
    }

    @GetMapping("/foundAll")
    public ResponseEntity<?> findAll() {
        List<EvaluationFindAllDto> findAllList = evaluationService.evaluationFindAll();
        log.info("findAll : {} ", findAllList);

        return ResponseEntity.ok().body(findAllList);
    }
}

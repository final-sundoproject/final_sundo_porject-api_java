package com.project.sundo_project.evaluation.controller;

import com.project.sundo_project.evaluation.dto.request.EvaluationSaveDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindAllDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindDto;
import com.project.sundo_project.evaluation.service.EvaluationService;
import com.project.sundo_project.location.entity.Location;
import com.project.sundo_project.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<?> register(
            @RequestParam("arImage") MultipartFile uploadFile,
            @RequestParam("title") String title,
            @RequestParam("registrantName") String registrantName,
            @RequestParam("windVolume") int windVolume,
            @RequestParam("noiseLevel") int noiseLevel,
            @RequestParam("scenery") int scenery,
            @RequestParam("waterDepth") int waterDepth,
            @RequestParam("companyCode") long companyCode,
            @RequestParam("locationId") String locationId) throws IOException {

        EvaluationSaveDto dto = new EvaluationSaveDto(title, registrantName, windVolume, noiseLevel, scenery, waterDepth, companyCode);

        log.info("uploadFile: {}", uploadFile);
        log.info("dto: {}", dto);

        Location findId = locationService.findById(locationId);


        evaluationService.save(uploadFile,dto,findId);

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

    @GetMapping("/foundAll/{companyCode}")
    public ResponseEntity<?> findAll(@PathVariable long companyCode) {
        List<EvaluationFindAllDto> findAllList = evaluationService.evaluationFindAll(companyCode);
        log.info("findAll : {} ", findAllList);

        return ResponseEntity.ok().body(findAllList);
    }
}
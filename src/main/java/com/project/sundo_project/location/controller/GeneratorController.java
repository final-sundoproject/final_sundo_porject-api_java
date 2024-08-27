package com.project.sundo_project.location.controller;

import com.project.sundo_project.location.dto.GeneratorDto;
import com.project.sundo_project.location.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generator")
@RequiredArgsConstructor
@Slf4j
public class GeneratorController {

    private final GeneratorService generatorService;

    // 방향 각도 및 발전기 저장
    @PostMapping("/{locationId}")
    public ResponseEntity<?>registerGenerator(@RequestBody GeneratorDto generatorDto, @PathVariable Long locationId){
        generatorService.saveGenerator(generatorDto ,locationId);
        return ResponseEntity.ok("방향 각도 및 발전기 정보가 등록되었습니다.");
    }

}

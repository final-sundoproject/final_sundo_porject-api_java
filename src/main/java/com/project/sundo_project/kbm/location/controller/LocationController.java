package com.project.sundo_project.kbm.location.controller;

import com.project.sundo_project.kbm.location.dto.LocationDto;
import com.project.sundo_project.kbm.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Slf4j
public class LocationController {

    private final LocationService locationService;

    // DMS(도분초) 좌표값 저장
    @PostMapping
    public ResponseEntity<?> registerLocation(@RequestBody LocationDto locationDto) {
        locationService.saveDmsLocation(locationDto);
        return ResponseEntity.ok("좌표가 등록되었습니다.");
    }


}

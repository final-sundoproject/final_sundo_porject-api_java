package com.project.sundo_project.location.controller;

import com.project.sundo_project.location.dto.LocationDto;
import com.project.sundo_project.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // DMS(도분초) 좌표값 저장
    @PostMapping
    public ResponseEntity<?> registerLocation(@RequestBody LocationDto locationDto) {
        locationService.saveDmsLocation(locationDto);
        return ResponseEntity.ok("좌표가 등록되었습니다.");
    }
}

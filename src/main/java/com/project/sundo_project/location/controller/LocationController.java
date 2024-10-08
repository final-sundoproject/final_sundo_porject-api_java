package com.project.sundo_project.location.controller;

import com.project.sundo_project.location.dto.LocationDto;
import com.project.sundo_project.location.entity.Location;
import com.project.sundo_project.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class LocationController {

    private final LocationService locationService;

    // 좌표값 저장
    @PostMapping("/{projectId}")
    public ResponseEntity<?> registerLocation(@RequestBody LocationDto locationDto,@PathVariable Long projectId) {
        // LocationDto를 사용하여 Location 엔티티를 생성하고 DB에 저장
        Location savedLocaiton = locationService.saveDmsLocation(locationDto,projectId);

        // 저장된 location의 ID를 반환
        Long locationID = savedLocaiton.getLocationID();

        // locationId를 클라이언트에 반환
        return ResponseEntity.ok(locationID);
    }


}

package com.project.sundo_project.kbm.location.controller;

import com.project.sundo_project.kbm.location.dto.LocationDto;
import com.project.sundo_project.kbm.location.entity.Location;
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
        // LocationDto를 사용하여 Location 엔티티를 생성하고 DB에 저장
        Location savedLocaiton = locationService.saveDmsLocation(locationDto);

        // 저장된 location의 ID를 반환
        Long locationID = savedLocaiton.getLocationID();

        // locationId를 클라이언트에 반환
        return ResponseEntity.ok(locationID);
    }


}

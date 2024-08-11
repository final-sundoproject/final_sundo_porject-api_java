package com.project.sundo_project.kbm.location.service;

import com.project.sundo_project.kbm.location.dto.LocationDto;
import com.project.sundo_project.kbm.location.entity.Location;
import com.project.sundo_project.kbm.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;

    // DMS(도분초) 좌표값 저장
    public Location saveDmsLocation(LocationDto locationDto) {
        Location saveDms = locationDto.toEntity(); // LocationDto를 Entity로 변환

        saveDms.setRegistrationDate(LocalDateTime.now());
        Location savedLocation = locationRepository.save(saveDms); // 저장된 Location 객체를 반환

        log.info("saveDms : {}", savedLocation);
        return savedLocation; // 저장된 Location 객체를 반환
    }
}

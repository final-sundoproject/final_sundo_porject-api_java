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
    public void saveDmsLocation(LocationDto locationDto) {
        Location saveDms = locationDto.toEntity();

        saveDms.setRegistrationDate(LocalDateTime.now());
        locationRepository.save(saveDms);

        log.info("saveDms : {}", saveDms );
    }


}
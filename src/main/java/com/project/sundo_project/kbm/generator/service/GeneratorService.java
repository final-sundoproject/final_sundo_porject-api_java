package com.project.sundo_project.kbm.generator.service;


import com.project.sundo_project.kbm.generator.dto.GeneratorDto;
import com.project.sundo_project.kbm.generator.entity.Generator;
import com.project.sundo_project.kbm.generator.repository.GeneratorRepository;
import com.project.sundo_project.kbm.location.entity.Location;
import com.project.sundo_project.kbm.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GeneratorService {

    private final GeneratorRepository generatorRepository;

    private final LocationRepository locationRepository;

    public void saveGenerator(GeneratorDto generatorDto, Long locationId) {

        Generator generatorDtoEntity = generatorDto.toEntity();
        Generator saveGenerator = generatorRepository.save(generatorDtoEntity);

        Location locationById = getLocationById(locationId);

        saveGenerator.setLocationId(locationById);
        generatorRepository.save(saveGenerator);

        log.info("saveGenerator : {}", saveGenerator);
    }

    public Location getLocationById(Long locationId) {
        // 주어진 locationId에 해당하는 Location 조회
        Optional<Location> locationOptional = locationRepository.findById(locationId);

        // Location이 존재하는 경우 반환, 존재하지 않을 경우 예외 처리
        return locationOptional.orElse(null); // 또는 원하는 예외를 던질 수 있습니다.
    }
}


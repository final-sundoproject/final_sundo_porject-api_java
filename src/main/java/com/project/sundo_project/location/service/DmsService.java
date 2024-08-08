package com.project.sundo_project.location.service;

import com.project.sundo_project.location.dto.DmsDto;
import com.project.sundo_project.location.entity.Dms;
import com.project.sundo_project.location.repository.DmsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DmsService {

    private final DmsRepository dmsRepository;

    public void saveDmsLocation(DmsDto dmsDto) {
        Dms saveDms = dmsDto.toEntity();

        saveDms.setRegistrationDate(LocalDateTime.now());
        dmsRepository.save(saveDms);

        log.info("saveDms : {}", saveDms );
    }
}

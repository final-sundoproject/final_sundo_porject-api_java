package com.project.sundo_project.service;

import com.project.sundo_project.dto.request.EvaluationSaveDto;
import com.project.sundo_project.entity.Evaluation;
import com.project.sundo_project.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public void save(EvaluationSaveDto dto){

        Evaluation evaluation = dto.toEntity();

        int avg = (evaluation.getWindVolume() + evaluation.getNoiseLevel()
                + evaluation.getScenery() + evaluation.getWaterDepth()) / 4;

        evaluation.setAverageRating(avg);
        evaluation.setPriRegistrationDate(LocalDateTime.now());

        log.info("evaluation + avg :{} " , evaluation);

        evaluationRepository.save(evaluation);
    }

}

package com.project.sundo_project.service;

import com.project.sundo_project.dto.request.EvaluationSaveDto;
import com.project.sundo_project.entity.Evaluation;
import com.project.sundo_project.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public void save(EvaluationSaveDto dto){

        Evaluation evaluation = dto.toEntity();
        log.info("evaluation : {}",evaluation);


        evaluationRepository.save(evaluation);
    }

}

package com.project.sundo_project.evaluation.service;

import com.project.sundo_project.evaluation.dto.request.EvaluationSaveDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindAllDto;
import com.project.sundo_project.evaluation.dto.response.EvaluationFindDto;
import com.project.sundo_project.evaluation.entity.Evaluation;
import com.project.sundo_project.evaluation.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final FileUploadService fileUploadService;

    public void save(MultipartFile uploadFile, EvaluationSaveDto dto) throws IOException {

        Evaluation evaluation = dto.toEntity();

        String arImg = fileUploadService.uploadProfileImage(uploadFile);

        int avg = (evaluation.getWindVolume() + evaluation.getNoiseLevel()
                + evaluation.getScenery() + evaluation.getWaterDepth()) / 4;

        evaluation.setAverageRating(avg);
        evaluation.setPriRegistrationDate(LocalDateTime.now());
        evaluation.setArImage(arImg);

        log.info("evaluation + avg :{} " , evaluation);

        evaluationRepository.save(evaluation);
    }

    public void deleteById(Long id){
        evaluationRepository.deleteById(id);
    }

    public void modify(EvaluationSaveDto dto, Long id){
        Evaluation foundEvaluation = evaluationRepository.findById(id).orElseThrow();
        foundEvaluation.modifyEvaluation(dto);

        evaluationRepository.save(foundEvaluation);

    }

    public List<EvaluationFindAllDto> evaluationFindAll() {
        List<Evaluation> foundAll = evaluationRepository.findAll();
        log.info("service repo foundAll : {}", foundAll);

        return  foundAll.stream().map(
                evaluation -> new EvaluationFindAllDto(
                        evaluation.getTitle(),
                        evaluation.getRegistrantName(),
                        evaluation.getPriRegistrationDate(),
                        evaluation.getArImage(),
                        evaluation.getWindVolume(),
                        evaluation.getNoiseLevel(),
                        evaluation.getWaterDepth(),
                        evaluation.getScenery(),
                        evaluation.getAverageRating(),
                        evaluation.getEvaluationID()
                )
        ).collect(Collectors.toList());
    }

    public EvaluationFindDto findById(Long id){
        Evaluation foundId = evaluationRepository.findById(id).orElseThrow();
        log.info("foundID : {} ",foundId);

        return new EvaluationFindDto(foundId);

    }

}

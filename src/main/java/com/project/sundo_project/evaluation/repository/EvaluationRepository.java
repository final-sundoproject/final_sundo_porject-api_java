package com.project.sundo_project.evaluation.repository;

import com.project.sundo_project.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {

    List<Evaluation> findAllByCompanyCode(long companyCode);
}

package com.project.sundo_project.kbm.generator.repository;

import com.project.sundo_project.kbm.generator.entity.Generator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratorRepository extends JpaRepository<Generator,Long> {
}

package com.project.sundo_project.location.repository;

import com.project.sundo_project.location.entity.Generator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratorRepository extends JpaRepository<Generator,Long> {
}

package com.project.sundo_project.location.repository;

import com.project.sundo_project.location.entity.Dms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsRepository extends JpaRepository<Dms, Long> {

}

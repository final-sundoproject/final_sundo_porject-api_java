package com.project.sundo_project.kbm.location.repository;

import com.project.sundo_project.kbm.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}

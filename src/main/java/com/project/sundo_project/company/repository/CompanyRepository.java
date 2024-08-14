package com.project.sundo_project.company.repository;

import com.project.sundo_project.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {  // Integer에서 Long으로 변경
    Optional<Company> findByCompanyEmail(String email);

    // 회사명으로 조회
    Optional<Company> findByCompanyName(String companyName);
}

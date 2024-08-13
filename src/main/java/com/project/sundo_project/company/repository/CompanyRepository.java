package com.project.sundo_project.company.repository;

import com.project.sundo_project.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByCompanyEmail(String email);
    // 필요한 경우 추가적인 쿼리 메소드 정의 가능

    // 회사명으로 조회
    Optional<Company> findByCompanyName(String companyName);
}

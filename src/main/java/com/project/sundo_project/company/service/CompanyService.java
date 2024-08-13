package com.project.sundo_project.company.service;

import com.project.sundo_project.company.entity.Company;
import com.project.sundo_project.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Company> loginCompany(String email, String rawPassword) {
        System.out.println("Received email: " + email);

        // 이메일로 회사 조회
        Optional<Company> company = companyRepository.findByCompanyEmail(email);

        if (company.isPresent()) {
            System.out.println("Found company with email: " + company.get().getCompanyEmail());

            // 비밀번호 검증
            if (passwordEncoder.matches(rawPassword, company.get().getPassword())) {
                return company; // 로그인 성공
            } else {
                System.out.println("Password does not match.");
                return Optional.empty(); // 비밀번호 불일치
            }
        }

        System.out.println("No company found with email: " + email);
        return Optional.empty(); // 이메일 불일치
    }

    public Company registerCompany(Company company) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(company.getPassword());
        company.setPassword(encodedPassword);

        // 회사 정보 저장
        return companyRepository.save(company);
    }

    // 회사명을 기반으로 이메일 찾기
    public Optional<String> findEmailByCompanyName(String companyName) {
        Optional<Company> companyOptional = companyRepository.findByCompanyName(companyName);
        return companyOptional.map(Company::getCompanyEmail);
    }
}

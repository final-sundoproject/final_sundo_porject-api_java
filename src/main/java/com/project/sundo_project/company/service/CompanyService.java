package com.project.sundo_project.company.service;

import com.project.sundo_project.company.entity.Company;
import com.project.sundo_project.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 이메일, 회사명, 주소, 사업자등록번호로 회사 정보 조회
    public Optional<Company> findCompanyByDetails(String companyEmail, String companyName, String companyAddress, String businessNumber) {
        return companyRepository.findByCompanyEmailAndCompanyNameAndCompanyAddressAndBusinessNumber(
                companyEmail, companyName, companyAddress, businessNumber);
    }

    public Optional<Company> findByEmail(String companyEmail) {
        return companyRepository.findByCompanyEmail(companyEmail);
    }

//    public void updatePassword(Company company, String newPassword) {
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        company.setPassword(encodedPassword);
//        companyRepository.save(company);
//    }

    public boolean updatePassword(Optional<Company> companyOptional, String newPassword) {
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            company.setPassword(encodedPassword);
            companyRepository.save(company);
            return true; // 비밀번호 변경 성공
        } else {
            return false; // 회사가 존재하지 않음
        }
    }

}

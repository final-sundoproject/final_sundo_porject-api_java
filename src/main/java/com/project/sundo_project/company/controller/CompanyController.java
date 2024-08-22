package com.project.sundo_project.company.controller;

import com.project.sundo_project.company.dto.request.LoginRequest;
import com.project.sundo_project.company.entity.Company;
import com.project.sundo_project.company.service.CompanyService;
import com.project.sundo_project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Company company) {
        Company registeredCompany = companyService.registerCompany(company);
        return ResponseEntity.ok(registeredCompany);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<Company> company = companyService.loginCompany(email, password);
        if (company.isPresent()) {
            // JWT 생성
            Long companyCode = company.get().getCompanyCode(); // companyCode 가져오기
            String token = jwtUtil.generateToken(email, companyCode);
            String companyName = company.get().getCompanyName();

            // 토큰과 companyCode를 함께 응답
            Map<String, Object> response = new HashMap<>();
            response.put("companyName", companyName);
            response.put("token", token);
            response.put("companyCode", companyCode);

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/find-email")
    public ResponseEntity<?> findEmailByCompanyName(@RequestParam String companyName) {
        Optional<String> emailOptional = companyService.findEmailByCompanyName(companyName);
        if (emailOptional.isPresent()) {
            return ResponseEntity.ok(emailOptional.get());
        }
        return ResponseEntity.status(404).body("Company not found");
    }

    @GetMapping("/find-password")
    public ResponseEntity<?> findPassword(@RequestParam String companyEmail,
                                          @RequestParam String companyName,
                                          @RequestParam String companyAddress,
                                          @RequestParam String businessNumber) {
        Optional<Company> company = companyService.findCompanyByDetails(companyEmail, companyName, companyAddress, businessNumber);
        if (company.isPresent()) {
            // 회사 정보가 일치하면 성공 응답
            return ResponseEntity.ok("Verification success");
        } else {
            // 회사 정보가 일치하지 않으면 404 응답
            return ResponseEntity.status(404).body("Company details not found");
        }
    }
    /**
     * 비밀번호 재설정
     */
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String companyEmail = request.get("companyEmail");
        String newPassword = request.get("newPassword");

        Optional<Company> company = companyService.findByEmail(companyEmail);
        boolean isUpdated = companyService.updatePassword(company, newPassword);
        if (isUpdated) {
            return ResponseEntity.ok("Password reset successful");
        } else {
            return ResponseEntity.status(404).body("Company not found");
        }
    }



}

package com.project.sundo_project.company.controller;

import com.project.sundo_project.company.dto.request.LoginRequest;
import com.project.sundo_project.company.entity.Company;
import com.project.sundo_project.company.service.CompanyService;
import com.project.sundo_project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
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
            String token = jwtUtil.generateToken(email);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
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

}

package com.project.sundo_project.company;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderTest {

    @Test
    public void testPasswordVerification() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 저장된 암호화된 비밀번호
        String storedEncodedPassword = "$2a$10$AO04LE8Zs9F687lfRtjLhepeAhw9upAPN2APqxKH7Qq6j4oOkM4T.";

        // 사용자가 입력한 비밀번호
        String rawPassword = "abc123";

        // 비밀번호가 맞는지 검증
        boolean matches = passwordEncoder.matches(rawPassword, storedEncodedPassword);

        // 출력하여 검증
        System.out.println("Password matches: " + matches);
        assertTrue(matches);
    }
}

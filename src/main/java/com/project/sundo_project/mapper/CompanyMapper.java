package com.project.sundo_project.mapper;

import com.project.sundo_project.dto.request.AutoLoginDto;
import com.project.sundo_project.entity.Company;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    // 회원가입
    boolean save(Company company);

    // 회원 정보 개별 조회
    Company findOne(String companyEmail);

    // 중복 확인 (아이디, 이메일)
    /**
     *
     * @param type - 어떤걸 중복검사할지 (ex: account OR email)
     * @param keyword - 중복검사할 실제값
     * @return - 중복이면 true, 아니면 false
     */
    boolean existsByEmail(
            @Param("type") String type,
            @Param("keyword") String keyword
    );

    // 자동로그인 쿠키값, 만료시간 업데이트
    void updateAutoLogin(AutoLoginDto dto);

    // 세션아이디로 회원정보 조회
    Company findMemberBySessionId(String sessionId);
}

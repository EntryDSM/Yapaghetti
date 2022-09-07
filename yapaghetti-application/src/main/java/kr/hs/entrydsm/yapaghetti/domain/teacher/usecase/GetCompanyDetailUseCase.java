package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.GetCompanyDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class GetCompanyDetailUseCase implements GetCompanyDetailPort {

    private final TeacherQueryCompanyPort teacherQueryCompanyPort;
    private final TeacherQueryUserPort teacherQueryUserPort;

    public CompanyDetailResponse execute(UUID companyId) {
        Company company = teacherQueryCompanyPort.queryCompanyById(companyId);
        User user = teacherQueryUserPort.queryUserById(company.getUserId());

        return CompanyDetailResponse.builder()
                .companyId(companyId.toString())
                .name(user.getName())
                .companyName(company.getCompanyName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .location(user.getLocation())
                .profileImagePath(user.getProfileImagePath())
                .startAt(company.getStartAt())
                .endAt(company.getEndAt())
                .isMou(UserRole.MOU.equals(user.getRole()))
                .build();
    }

}

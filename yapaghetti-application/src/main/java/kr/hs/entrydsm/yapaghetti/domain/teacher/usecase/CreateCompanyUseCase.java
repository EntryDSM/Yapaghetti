package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.NewCompanyResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateCompanyUseCase implements CreateCompanyPort {

    private final TeacherCommandUserPort teacherCommandUserPort;
    private final TeacherCommandCompanyPort teacherCommandCompanyPort;
    private final TeacherRandomStringPort teacherRandomStringPort;
    private final TeacherSecurityPort teacherSecurityPort;

    @Override
    public NewCompanyResponse execute(DomainNewCompanyRequest request) {
        String password = teacherRandomStringPort.getRandomPassword();

        User user = createUser(request, password);
        teacherCommandUserPort.saveUser(user);

        Company company = createCompany(request, user);
        teacherCommandCompanyPort.saveCompany(company);

        return new NewCompanyResponse(password);
    }

    private User createUser(DomainNewCompanyRequest request, String password) {
        return User.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .password(teacherSecurityPort.encodePassword(password))
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .location(request.getLocation())
                .role(request.getCompanyType())
                .isVisited(false)
                .profileImagePath(request.getProfileImagePath())
                .build();
    }

    private Company createCompany(DomainNewCompanyRequest request, User user) {
        return Company.builder()
                .userId(user.getId())
                .companyName(request.getCompanyName())
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .build();
    }


}

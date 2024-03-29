package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.enums.EmailType;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.NewCompanyResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateCompanyUseCase implements CreateCompanyPort {

    private final TeacherCommandUserPort teacherCommandUserPort;
    private final TeacherCommandCompanyPort teacherCommandCompanyPort;
    private final TeacherRandomStringPort teacherRandomStringPort;
    private final TeacherSecurityPort teacherSecurityPort;
    private final SendMailPort sendMailPort;

    @Override
    public NewCompanyResponse execute(DomainNewCompanyRequest request) {
        String password = teacherRandomStringPort.getRandomPassword();

        User user = teacherCommandUserPort.saveUserAndGetUser(createUser(request, password));

        Company company = createCompany(request, user.getId());
        teacherCommandCompanyPort.saveCompany(company);

        List<String> values = List.of(user.getEmail(), password);
        sendMailPort.sendAuthCode(user.getEmail(), values, EmailType.CREATE_COMPANY);

        return new NewCompanyResponse(password);
    }

    private User createUser(DomainNewCompanyRequest request, String password) {
        UserRole userRole = Boolean.TRUE.equals(request.getIsMou()) ? UserRole.MOU : UserRole.NON_MOU;

        return User.builder()
                .name(request.getName())
                .password(teacherSecurityPort.encodePassword(password))
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .location(request.getLocation())
                .role(userRole)
                .isVisited(false)
                .profileImagePath(request.getProfileImagePath())
                .build();
    }

    private Company createCompany(DomainNewCompanyRequest request, UUID userId) {
        return Company.builder()
                .userId(userId)
                .companyName(request.getCompanyName())
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .build();
    }
}

package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.enums.EmailType;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.ChangeCompanyPasswordPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ChangeCompanyPasswordResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class ChangeCompanyPasswordUseCase implements ChangeCompanyPasswordPort {

    private final TeacherQueryUserPort teacherQueryUserPort;
    private final TeacherCommandUserPort teacherCommandUserPort;
    private final TeacherRandomStringPort teacherRandomStringPort;
    private final TeacherSecurityPort teacherSecurityPort;
    private final SendMailPort sendMailPort;

    @Override
    public ChangeCompanyPasswordResponse execute(UUID companyId) {
        User user = teacherQueryUserPort.queryUserById(companyId);
        String password = teacherRandomStringPort.getRandomPassword();
        String encodePassword = teacherSecurityPort.encodePassword(password);

        teacherCommandUserPort.saveUser(
                user.updatePassword(encodePassword)
        );

        List<String> values = List.of(password);
        sendMailPort.sendAuthCode(user.getEmail(), values, EmailType.RESET_PASSWORD);

        return new ChangeCompanyPasswordResponse(password);
    }

}

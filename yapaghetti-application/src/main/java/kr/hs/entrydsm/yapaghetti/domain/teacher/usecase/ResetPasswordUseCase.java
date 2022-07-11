package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.ResetPasswordPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ResetPasswordResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class ResetPasswordUseCase implements ResetPasswordPort {

    private final TeacherQueryUserPort teacherQueryUserPort;
    private final TeacherCommandUserPort teacherCommandUserPort;
    private final TeacherRandomStringPort teacherRandomStringPort;
    private final TeacherSecurityPort teacherSecurityPort;

    @Override
    public ResetPasswordResponse execute(UUID companyId) {
        User user = teacherQueryUserPort.queryUserById(companyId);
        String password = teacherRandomStringPort.getRandomPassword();

        savePassword(user, password);

        return ResetPasswordResponse.builder()
                .password(password)
                .build();
    }

    private void savePassword(User user, String password) {
        String encodePassword = teacherSecurityPort.encodePassword(password);
        teacherCommandUserPort.saveUser(
                user.updatePassword(encodePassword)
        );
    }

}

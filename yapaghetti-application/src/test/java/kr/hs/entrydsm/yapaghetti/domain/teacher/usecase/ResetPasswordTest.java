package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ResetPasswordTest {

    @Mock
    TeacherQueryUserPort teacherQueryUserPort;

    @Mock
    TeacherCommandUserPort teacherCommandUserPort;

    @Mock
    TeacherRandomStringPort teacherRandomStringPort;

    @Mock
    TeacherSecurityPort teacherSecurityPort;

    @Mock
    SendMailPort sendMailPort;

    @InjectMocks
    ChangeCompanyPasswordUseCase resetCompanyPasswordUseCase;

    @Test
    public void execute() {

        UUID companyId = UUID.randomUUID();
        String email = "test@dsm.hs.kr";
        String password = "password";

        given(teacherRandomStringPort.getRandomPassword())
            .willReturn(password);

        given(teacherQueryUserPort.queryUserById(companyId))
                .willReturn(
                        User.builder()
                                .id(companyId)
                                .email(email)
                                .build()
                );


        resetCompanyPasswordUseCase.execute(companyId);

    }

}

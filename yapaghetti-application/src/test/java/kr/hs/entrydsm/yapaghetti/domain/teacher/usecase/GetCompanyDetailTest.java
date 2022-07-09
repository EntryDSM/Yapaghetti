package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GetCompanyDetailTest {

    @Mock
    TeacherQueryUserPort teacherQueryUserPort;

    @Mock
    TeacherQueryCompanyPort teacherQueryCompanyPort;

    @InjectMocks
    GetCompanyDetailUseCase getCompanyDetailUseCase;

    @Test
    public void execute() {

        UUID companyId = UUID.randomUUID();

        given(teacherQueryUserPort.queryUserById(companyId))
                .willReturn(
                        User.builder()
                        .id(companyId)
                        .build()
                );

        given(teacherQueryCompanyPort.queryCompanyByUserId(companyId))
                .willReturn(
                        Company.builder()
                                .userId(companyId)
                                .build()
                );

        getCompanyDetailUseCase.execute(companyId);
    }
}

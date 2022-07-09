package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainUpdateCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UpdateCompanyTest {

    @Mock
    TeacherQueryCompanyPort teacherQueryCompanyPort;

    @Mock
    TeacherCommandCompanyPort teacherCommandCompanyPort;

    @Mock
    TeacherQueryUserPort teacherQueryUserPort;

    @Mock
    TeacherCommandUserPort teacherCommandUserPort;

    @Mock
    DomainUpdateCompanyRequest request;

    @InjectMocks
    UpdateCompanyUseCase updateCompanyUseCase;

    @Test
    public void execute() {

        UUID userId = UUID.randomUUID();

        given(teacherQueryUserPort.queryUserById(userId))
                .willReturn(
                        User.builder()
                                .id(userId)
                                .build()
                );

        given(teacherQueryCompanyPort.queryCompanyByUserId(userId))
                .willReturn(
                        Company.builder()
                                .userId(userId)
                                .build()
                );

        given(request.getCompanyId())
                .willReturn(userId);

        updateCompanyUseCase.execute(request);

    }

}

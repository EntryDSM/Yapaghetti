package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DeleteCompanyUseCaseTest {
    @Mock
    TeacherCommandCompanyPort teacherCommandCompanyPort;

    @Mock
    TeacherQueryCompanyPort teacherQueryCompanyPort;

    @InjectMocks
    DeleteCompanyUseCase deleteCompanyUseCase;

    @Test
    public void deleteCompany() {
        UUID companyId = UUID.randomUUID();

        given(teacherQueryCompanyPort.queryCompanyById(companyId))
                .willReturn(Company.builder()
                        .userId(companyId)
                        .build()
                );

        deleteCompanyUseCase.execute(companyId);

    }
}

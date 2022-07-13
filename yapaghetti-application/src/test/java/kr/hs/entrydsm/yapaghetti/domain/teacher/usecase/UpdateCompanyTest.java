package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainUpdateCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UpdateCompanyTest {

    @Mock
    TeacherQueryCompanyPort teacherQueryCompanyPort;

    @Mock
    TeacherCommandCompanyPort teacherCommandCompanyPort;

    @Mock
    DomainUpdateCompanyRequest request;

    @InjectMocks
    UpdateCompanyUseCase updateCompanyUseCase;

    @Test
    public void execute() {

        UUID userId = UUID.randomUUID();

        given(teacherQueryCompanyPort.queryCompanyById(userId))
                .willReturn(
                        Company.builder()
                                .userId(userId)
                                .build()
                );

        given(request.getCompanyId())
                .willReturn(userId);

        given(request.getCompanyName())
                .willReturn("엔트리");

        given(request.getStartAt())
                .willReturn(LocalDateTime.now());

        given(request.getEndAt())
                .willReturn(LocalDateTime.now());

        updateCompanyUseCase.execute(request);

    }

}

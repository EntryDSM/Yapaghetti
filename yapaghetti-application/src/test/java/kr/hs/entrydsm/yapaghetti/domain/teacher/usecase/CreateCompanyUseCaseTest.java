package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CreateCompanyUseCaseTest {

    @Mock
    TeacherCommandUserPort teacherCommandUserPort;

    @Mock
    TeacherCommandCompanyPort teacherCommandCompanyPort;

    @Mock
    TeacherRandomStringPort teacherRandomStringPort;

    @Mock
    TeacherSecurityPort teacherSecurityPort;

    @Mock
    DomainNewCompanyRequest request;

    @InjectMocks
    CreateCompanyUseCase createCompanyUseCase;

    @Test
    public void execute() {
        LocalDateTime startAt = LocalDateTime.now();
        LocalDateTime endAt = LocalDateTime.now();
        String name = "testName";
        String companyName = "entry";
        String location = "대전";
        String email = "entry@dsm.hs.kr";
        String phoneNumber = "01011111111";

        given(request.getName())
                .willReturn(name);

        given(request.getCompanyName())
                .willReturn(companyName);

        given(request.getLocation())
                .willReturn(location);

        given(request.getEmail())
                .willReturn(email);

        given(request.getPhoneNumber())
                .willReturn(phoneNumber);

        given(request.getEndAt())
                .willReturn(endAt);

        given(request.getStartAt())
                .willReturn(startAt);

        createCompanyUseCase.execute(request);

    }

}

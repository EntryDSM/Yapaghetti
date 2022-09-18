package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateCompanyUseCaseTest {

    @Mock
    TeacherCommandUserPort teacherCommandUserPort;

    @Mock
    TeacherCommandCompanyPort teacherCommandCompanyPort;

    @Mock
    TeacherRandomStringPort teacherRandomStringPort;

    @Mock
    TeacherSecurityPort teacherSecurityPort;

    @Mock
    SendMailPort sendMailPort;

    @Mock
    DomainNewCompanyRequest request;

    @InjectMocks
    CreateCompanyUseCase createCompanyUseCase;

    @Test
    void 기업_생성_Mou() {
        LocalDateTime startAt = LocalDateTime.now();
        LocalDateTime endAt = LocalDateTime.now();
        String name = "testName";
        String companyName = "entry";
        String location = "대전";
        String email = "entry@dsm.hs.kr";
        String phoneNumber = "01011111111";
        String password = "password";
        UUID uuid = UUID.randomUUID();
        User user = User.builder()
            .id(uuid)
            .email(email)
            .build();

        given(teacherRandomStringPort.getRandomPassword())
            .willReturn(password);
        given(teacherCommandUserPort.saveUserAndGetUser(any()))
            .willReturn(user);
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
        given(request.getIsMou())
                .willReturn(true);

        createCompanyUseCase.execute(request);

    }

    @Test
    void 기업_생성_Not_Mou() {
        LocalDateTime startAt = LocalDateTime.now();
        LocalDateTime endAt = LocalDateTime.now();
        String name = "testName";
        String companyName = "entry";
        String location = "대전";
        String email = "entry@dsm.hs.kr";
        String phoneNumber = "01011111111";
        String password = "password";
        UUID uuid = UUID.randomUUID();
        User user = User.builder()
            .id(uuid)
            .email(email)
            .build();

        given(teacherRandomStringPort.getRandomPassword())
            .willReturn(password);
        given(teacherCommandUserPort.saveUserAndGetUser(any()))
            .willReturn(user);
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
        given(request.getIsMou())
                .willReturn(false);

        createCompanyUseCase.execute(request);

    }

}

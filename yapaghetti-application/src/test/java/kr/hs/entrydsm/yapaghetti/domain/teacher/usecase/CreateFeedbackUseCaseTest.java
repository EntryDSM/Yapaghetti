package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
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
public class CreateFeedbackUseCaseTest {

    @Mock
    CommandFeedbackPort commandFeedbackPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    TeacherQueryUserPort teacherQueryUserPort;

    @Mock
    SendMailPort sendMailPort;

    @InjectMocks
    CreateFeedbackUseCase createFeedbackUseCase;

    @Mock
    DomainCreateFeedbackRequest request;

    @Test
    void testCreateFeedback() {
        UUID studentId = UUID.randomUUID();
        Integer sequence = 1;
        String comment = "이 부분 알잘딱 실패!!";
        String email = "test@dsm.hs.kr";

        given(request.getStudentId())
                .willReturn(studentId);

        given(request.getSequence())
                .willReturn(sequence);

        given(request.getComment())
                .willReturn(comment);

        given(queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY))
                .willReturn(Document.builder().build());

        given(teacherQueryUserPort.queryUserById(studentId))
            .willReturn(User.builder()
                .email(email)
                .build());
        createFeedbackUseCase.execute(request);

    }

}

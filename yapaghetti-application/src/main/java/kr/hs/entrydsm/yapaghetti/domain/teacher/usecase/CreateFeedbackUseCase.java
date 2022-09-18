package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.enums.EmailType;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateFeedbackUseCase implements CreateFeedbackPort {

    private final CommandFeedbackPort commandFeedbackPort;
    private final QueryDocumentPort queryDocumentPort;
    private final TeacherQueryUserPort teacherQueryUserPort;
    private final SendMailPort sendMailPort;

    @Override
    public void execute(DomainCreateFeedbackRequest request) {

        UUID documentId = queryDocumentPort.queryDocumentByUserIdAndType(
                request.getStudentId(), DocumentType.STAY
        ).getId();

        commandFeedbackPort.saveFeedback(
                Feedback.builder()
                        .documentId(documentId)
                        .sequence(request.getSequence())
                        .comment(request.getComment())
                        .isApply(false)
                        .build()
        );

        User user = teacherQueryUserPort.queryUserById(request.getStudentId());

        sendMailPort.sendAuthCode(user.getEmail(), List.of(), EmailType.ARRIVED_FEEDBACK);
    }
}

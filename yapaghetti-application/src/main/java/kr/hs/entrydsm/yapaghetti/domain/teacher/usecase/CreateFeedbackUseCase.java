package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateFeedbackUseCase implements CreateFeedbackPort {

    private final CommandFeedbackPort commandFeedbackPort;

    private final QueryDocumentPort queryDocumentPort;

    @Override
    public void createFeedback(DomainCreateFeedbackRequest request) {

        UUID documentId = queryDocumentPort.queryDocumentByUserIdAndType(
                request.getStudentId(), DocumentType.STAY
        ).getId();

        commandFeedbackPort.saveFeedback(
                Feedback.builder()
                        .documentId(documentId)
                        .sequence(request.getSequence())
                        .comment(request.getComment())
                        .build()
        );
    }
}

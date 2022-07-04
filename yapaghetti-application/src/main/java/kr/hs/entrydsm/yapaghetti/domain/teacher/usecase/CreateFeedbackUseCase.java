package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackAPI;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateFeedbackUseCase implements CreateFeedbackAPI {

    private final CommandFeedbackPort commandFeedbackPort;

    private final QueryDocumentPort queryDocumentPort;

    @Override
    public void createFeedback(DomainCreateFeedbackRequest domainCreateFeedbackRequest) {
        UUID documentId = queryDocumentPort.queryStayDocumentByUserId(
                domainCreateFeedbackRequest.getStudentId()
        ).getId();

        FeedBack feedBack = FeedBack.builder()
                .documentId(documentId)
                .sequence(domainCreateFeedbackRequest.getSequence())
                .content(domainCreateFeedbackRequest.getContent())
                .isApply(false)
                .build();

        commandFeedbackPort.saveFeedback(feedBack);
    }
}

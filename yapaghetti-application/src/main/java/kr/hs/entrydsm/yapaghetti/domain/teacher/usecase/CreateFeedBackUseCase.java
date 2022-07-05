package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedBackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedBackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedBackRequest;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateFeedBackUseCase implements CreateFeedBackPort {

    private final QueryDocumentPort queryDocumentPort;

    private final CommandFeedBackPort commandFeedBackPort;

    @Override
    public void createFeedBack(DomainCreateFeedBackRequest domainCreateFeedBackRequest) {
        UUID documentId = queryDocumentPort.queryDocumentByUserIdAndType(
                domainCreateFeedBackRequest.getStudentId(), DocumentType.STAY
        ).getId();

        commandFeedBackPort.saveFeedBack(
                FeedBack.builder()
                        .documentId(documentId)
                        .sequence(domainCreateFeedBackRequest.getSequence())
                        .comment(domainCreateFeedBackRequest.getContent())
                        .isApply(false)
                        .build()
        );

    }

}

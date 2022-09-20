package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.ApproveStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.exception.DocumentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentCommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class ApproveStayDocumentUseCase implements ApproveStayDocumentPort {

    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;
    private final DocumentCommandFeedbackPort documentCommandFeedbackPort;

    @Override
    public void execute(UUID studentId) {
        Document stayDocument = queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY);

        if (queryDocumentPort.checkDocumentByUserIdAndType(studentId, DocumentType.PUBLIC)) {
            commandDocumentPort.deleteDocument(
                    queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.PUBLIC)
            );
        }

        documentCommandFeedbackPort.deleteAllByDocumentId(
                stayDocument.getId()
        );

        commandDocumentPort.saveDocument(
                stayDocument.changeDocumentType(DocumentType.PUBLIC)
        );

    }
}

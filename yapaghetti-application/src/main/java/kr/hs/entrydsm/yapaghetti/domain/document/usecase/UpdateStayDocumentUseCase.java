package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateStayDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateStayDocumentUseCase implements UpdateStayDocumentPort {

    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;
    private final DocumentSecurityPort documentSecurityPort;

    @Override
    public void execute(DomainUpdateStayDocumentRequest request) {
        UUID currentUserId = documentSecurityPort.getCurrentUserId();
        Document stayDocument = queryDocumentPort.queryDocumentByUserIdAndType(currentUserId, DocumentType.STAY);

        commandDocumentPort.saveDocument(
                stayDocument.updateDocumentPreviewAndContent(request.getPreviewImagePath(), request.getContent())
        );
    }
}

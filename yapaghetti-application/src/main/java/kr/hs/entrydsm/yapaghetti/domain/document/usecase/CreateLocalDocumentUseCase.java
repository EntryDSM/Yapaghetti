package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateLocalDocumentUseCase implements CreateLocalDocumentPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void execute(DomainCreateLocalDocumentRequest request) {
        User user = documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        commandDocumentPort.saveDocument(
                Document.builder()
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .type(DocumentType.LOCAL)
                        .userId(user.getId())
                        .isApproved(false)
                        .build()
        );
    }
}

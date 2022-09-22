package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.CreateLocalDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateLocalDocumentUseCase implements CreateLocalDocumentPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public CreateLocalDocumentResponse execute(DomainCreateDocumentRequest request) {
        User user = documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        UUID documentId = commandDocumentPort.saveDocumentAndGetId(
                Document.builder()
                        .content(request.getContent())
                        .previewImagePath(request.getPreviewImagePath())
                        .type(DocumentType.LOCAL)
                        .userId(user.getId())
                        .isRejected(false)
                        .build()
        );

        return new CreateLocalDocumentResponse(documentId);
    }
}

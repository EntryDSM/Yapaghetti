package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.RequestLocalDocumentToPublicPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class RequestLocalDocumentToPublicUseCase implements RequestLocalDocumentToPublicPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void execute(UUID documentId) {
        User currentUser = documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        Document localDocument = queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                documentId, currentUser.getId(), DocumentType.LOCAL
        );

        commandDocumentPort.saveDocument(
                localDocument.changeDocumentType(DocumentType.STAY)
        );
    }
}

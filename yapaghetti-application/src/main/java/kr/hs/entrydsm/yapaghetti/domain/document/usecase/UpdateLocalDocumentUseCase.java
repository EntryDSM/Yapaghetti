package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateLocalDocumentUseCase implements UpdateLocalDocumentPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void execute(DomainUpdateLocalDocumentRequest request) {
        User currentUser = documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        Document document = queryDocumentPort
                .queryDocumentByIdAndUserIdAndType(
                        request.getDocumentId(), currentUser.getId(), DocumentType.LOCAL
                );

        commandDocumentPort.saveDocument(
                document.updateLocalDocument(request.getPreviewImagePath(), request.getContent())
        );
    }
}

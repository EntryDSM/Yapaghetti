package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CopyPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CopyPublicDocumentUseCase implements CopyPublicDocumentPort {

    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;
    private final UserSecurityPort userSecurityPort;

    @Override
    public void execute() {
        UUID currentUserId = userSecurityPort.getCurrentUserId();
        Document publicDocument = queryDocumentPort.queryDocumentByUserIdAndType(currentUserId, DocumentType.PUBLIC);

        commandDocumentPort.saveDocument(
                Document.builder()
                        .previewImagePath(publicDocument.getPreviewImagePath())
                        .content(publicDocument.getContent())
                        .type(DocumentType.LOCAL)
                        .userId(currentUserId)
                        .build()
        );
    }
}

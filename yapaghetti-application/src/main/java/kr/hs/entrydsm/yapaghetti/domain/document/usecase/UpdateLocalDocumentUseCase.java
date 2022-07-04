package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateLocalDocumentUseCase implements UpdateLocalDocumentPort {

    private final QueryUserPort queryUserPort;
    private final UserSecurityPort userSecurityPort;
    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void execute(DomainUpdateLocalDocumentRequest request) {
        User currentUser = queryUserPort.queryUserById(userSecurityPort.getCurrentUserId());

        Document document = queryDocumentPort
                .queryDocumentByIdAndUserIdAndType(
                        request.getDocumentId(), currentUser.getId(), DocumentType.LOCAL
                );

        commandDocumentPort.updateDocument(
                Document.builder()
                        .id(document.getId())
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .type(DocumentType.LOCAL)
                        .userId(currentUser.getId())
                        .build()
        );
    }
}

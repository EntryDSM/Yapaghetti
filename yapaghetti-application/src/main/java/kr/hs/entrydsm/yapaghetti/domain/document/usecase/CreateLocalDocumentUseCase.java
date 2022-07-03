package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateLocalDocumentUseCase implements CreateLocalDocumentPort {

    private final QueryUserPort queryUserPort;
    private final UserSecurityPort userSecurityPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void createLocalDocument(DomainCreateLocalDocumentRequest request) {
        User user = queryUserPort.queryUserByPublicId(userSecurityPort.getCurrentUserPublicId());

        commandDocumentPort.saveDocument(
                Document.builder()
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .type(DocumentType.LOCAL)
                        .user(user.getId())
                        .build()
        );
    }
}

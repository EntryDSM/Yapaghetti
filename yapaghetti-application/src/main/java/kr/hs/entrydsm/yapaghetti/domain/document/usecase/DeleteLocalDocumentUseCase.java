package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.DeleteLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteLocalDocumentUseCase implements DeleteLocalDocumentPort {

    private final UserSecurityPort userSecurityPort;
    private final QueryUserPort queryUserPort;
    private final QueryDocumentPort queryDocumentPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public void execute(UUID documentId) {
        User currentUser = queryUserPort.queryUserById(userSecurityPort.getCurrentUserId());

        Document document = queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                documentId,
                currentUser.getId(),
                DocumentType.LOCAL
        );

        commandDocumentPort.deleteDocument(document);
    }
}

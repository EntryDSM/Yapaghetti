package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryLocalDocumentUseCase implements QueryLocalDocumentPort {

    private final QueryUserPort queryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final QueryDocumentPort queryDocumentPort;

    @Override
    public QueryDocumentResponse execute(UUID documentId) {
        User user = queryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        Document document = queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                user.getId(),
                documentId,
                DocumentType.LOCAL
        );

        return new QueryDocumentResponse(document.getContent());
    }
}

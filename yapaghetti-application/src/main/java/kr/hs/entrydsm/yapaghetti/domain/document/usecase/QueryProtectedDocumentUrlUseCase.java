package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryProtectedDocumentUrlPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryProtectedDocumentUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryProtectedDocumentUrlUseCase implements QueryProtectedDocumentUrlPort {

    private static final String urlFormat = "https://yapaghetti.entrydsm.hs.kr/document/%s";
    private final QueryDocumentPort queryDocumentPort;
    private final DocumentSecurityPort documentSecurityPort;

    @Override
    public QueryProtectedDocumentUrlResponse execute() {
        UUID currentUserId = documentSecurityPort.getCurrentUserId();
        UUID documentId = queryDocumentPort.queryDocumentByUserIdAndType(currentUserId, DocumentType.PROTECTED).getId();

        String url = String.format(documentId.toString(), urlFormat);
        return new QueryProtectedDocumentUrlResponse(url);
    }
}

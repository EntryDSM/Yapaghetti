package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryPublicDocumentUseCase implements QueryPublicDocumentPort {

    private final QueryDocumentPort queryDocumentPort;

    @Override
    public QueryDocumentResponse execute(UUID studentId) {
        Document publicDocument = queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.PUBLIC);

        return new QueryDocumentResponse(publicDocument.getContent());
    }
}

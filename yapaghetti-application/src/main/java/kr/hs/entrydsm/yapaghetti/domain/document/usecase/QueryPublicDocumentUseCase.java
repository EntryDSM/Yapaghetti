package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryPublicDocumentUseCase implements QueryPublicDocumentPort {

    private final QueryDocumentPort queryDocumentPort;

    @Override
    public QueryDocumentResponse execute(UUID documentId) {
        Document document = queryDocumentPort.queryDocumentById(documentId);

        return new QueryDocumentResponse(document.getContent());
    }
}

package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryFeedBackResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryStayDocumentUseCase implements QueryStayDocumentPort {

    private final QueryDocumentPort queryDocumentPort;

    @Override
    public QueryStayDocumentResponse execute(UUID documentId) {
        Document stayDocument = queryDocumentPort.queryDocumentByIdAndType(documentId, DocumentType.STAY);

        List<QueryFeedBackResponse> feedBackList = new ArrayList<>(); // TODO feedback 조회

        return new QueryStayDocumentResponse(
                feedBackList,
                stayDocument.getContent()
        );
    }
}

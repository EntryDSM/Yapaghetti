package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.FeedbackElement;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryStayDocumentUseCase implements QueryStayDocumentPort {

    private final QueryDocumentPort queryDocumentPort;
    private final DocumentQueryFeedbackPort queryFeedbackPort;

    @Override
    public QueryStayDocumentResponse execute(UUID studentId) {
        Document stayDocument = queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY);

        List<FeedbackElement> feedbackList = queryFeedbackPort.queryFeedbackByDocumentId(stayDocument.getId())
                .stream()
                .map(f -> new FeedbackElement(f.getSequence(), f.getComment(), f.getIsApply()))
                .collect(Collectors.toList());

        return new QueryStayDocumentResponse(
                feedbackList,
                stayDocument.getContent()
        );
    }
}

package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayAndPublicDocumentPreviewPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayAndPublicDocumentPreviewResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.StayAndPublicDocumentElement;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryStayAndPublicDocumentPreviewUseCase implements QueryStayAndPublicDocumentPreviewPort {

    private final QueryDocumentPort queryDocumentPort;
    private final DocumentQueryStudentPort documentQueryStudentPort;

    @Override
    public QueryStayAndPublicDocumentPreviewResponse execute(UUID studentId) {
        Student student = documentQueryStudentPort.queryStudentById(studentId);

        List<DocumentType> types = List.of(DocumentType.LOCAL, DocumentType.PROTECTED);

        List<StayAndPublicDocumentElement> documentElements =
                queryDocumentPort.queryDocumentAllByUserIdAndTypeNotIn(student.getUserId(), types)
                        .stream()
                        .map(document -> new StayAndPublicDocumentElement(document.getType(), document.getPreviewImagePath()))
                        .collect(Collectors.toList());

        return new QueryStayAndPublicDocumentPreviewResponse(documentElements);
    }
}

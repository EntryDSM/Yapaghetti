package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayAndPublicDocumentPreviewPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayAndPublicDocumentPreviewResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryStayAndPublicDocumentPreviewUseCase implements QueryStayAndPublicDocumentPreviewPort {

    private final QueryDocumentPort queryDocumentPort;
    private final DocumentQueryStudentPort documentQueryStudentPort;

    @Override
    public QueryStayAndPublicDocumentPreviewResponse execute(UUID studentId) {
        Student student = documentQueryStudentPort.queryStudentById(studentId);

        Document stayDocument = queryDocumentPort
                .queryDocumentByUserIdAndType(student.getUserId(), DocumentType.STAY);
        Document publicDocument = queryDocumentPort
                .queryDocumentByUserIdAndType(student.getUserId(), DocumentType.PUBLIC);

        return new QueryStayAndPublicDocumentPreviewResponse(
                stayDocument.getPreviewImagePath(), publicDocument.getPreviewImagePath()
        );
    }
}

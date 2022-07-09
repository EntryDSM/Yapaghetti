package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryStayAndPublicDocumentPreviewUseCaseTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    DocumentQueryStudentPort documentQueryStudentPort;

    @InjectMocks
    QueryStayAndPublicDocumentPreviewUseCase queryPublicAndStayDocumentPreviewUseCase;

    @Test
    void QueryPublicAndStayDocumentPreview() {
        UUID studentId = UUID.randomUUID();
        String stayPreviewImagePath = "stayPreviewImagePath";
        String publicPreviewImagePath = "publicPreviewImagePath";

        given(documentQueryStudentPort.queryStudentById(studentId))
                .willReturn(
                        Student.builder()
                                .userId(studentId)
                                .build()
                );
        given(queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY))
                .willReturn(
                        Document.builder()
                                .type(DocumentType.STAY)
                                .previewImagePath(stayPreviewImagePath)
                                .build()
                );
        given(queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.PUBLIC))
                .willReturn(
                        Document.builder()
                                .type(DocumentType.PUBLIC)
                                .previewImagePath(publicPreviewImagePath)
                                .build()
                );

        queryPublicAndStayDocumentPreviewUseCase.execute(studentId);
    }

}
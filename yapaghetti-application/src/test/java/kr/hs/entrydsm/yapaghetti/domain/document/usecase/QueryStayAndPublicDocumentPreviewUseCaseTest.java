package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.StayAndPublicDocumentElement;
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

import java.util.ArrayList;
import java.util.List;
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
        String previewImagePath = "testPreviewImagePath";
        List<DocumentType> types = List.of(DocumentType.LOCAL, DocumentType.PROTECTED);


        given(documentQueryStudentPort.queryStudentById(studentId))
                .willReturn(
                        Student.builder()
                                .userId(studentId)
                                .build()
                );
        given(queryDocumentPort.queryDocumentAllByUserIdAndTypeNotIn(studentId, types))
                .willReturn(
                        List.of(
                                Document.builder()
                                        .type(DocumentType.STAY)
                                        .previewImagePath(previewImagePath)
                                        .build(),
                                Document.builder()
                                        .type(DocumentType.PUBLIC)
                                        .previewImagePath(previewImagePath)
                                        .build()
                        ));

        queryPublicAndStayDocumentPreviewUseCase.execute(studentId);
    }

}
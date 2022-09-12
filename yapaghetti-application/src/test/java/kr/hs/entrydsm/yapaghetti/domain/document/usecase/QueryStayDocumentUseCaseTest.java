package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryStayDocumentUseCaseTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    DocumentQueryFeedbackPort queryFeedbackPort;

    @InjectMocks
    QueryStayDocumentUseCase queryStayDocumentUseCase;

    @Test
    void queryStayDocument() {
        UUID documentId = UUID.randomUUID();

        given(queryDocumentPort.queryDocumentByIdAndType(documentId, DocumentType.STAY)).willReturn(
                Document.builder()
                        .content("testContent")
                        .build()
        );

        given(queryFeedbackPort.queryFeedbackByDocumentId(documentId)).willReturn(
                List.of(
                        Feedback.builder()
                                .sequence(1)
                                .comment("testComment")
                                .isApply(false)
                                .build(),
                        Feedback.builder()
                                .sequence(2)
                                .comment("testComment2")
                                .isApply(false)
                                .build()
                )
        );

        queryStayDocumentUseCase.execute(documentId);
    }
}

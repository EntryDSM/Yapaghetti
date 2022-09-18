package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ApproveStayDocumentUseCaseTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @InjectMocks
    ApproveStayDocumentUseCase approveStayDocumentUseCase;

    @Test
    void approveDocument() {
        UUID documentId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        given(queryDocumentPort.queryDocumentByUserIdAndType(userId, DocumentType.STAY)).willReturn(
                Document.builder()
                        .id(documentId)
                        .previewImagePath("testPreviewImagePath")
                        .content("testContent")
                        .type(DocumentType.STAY)
                        .userId(userId)
                        .isRejected(false)
                        .build()
        );

        approveStayDocumentUseCase.execute(userId);
    }
}

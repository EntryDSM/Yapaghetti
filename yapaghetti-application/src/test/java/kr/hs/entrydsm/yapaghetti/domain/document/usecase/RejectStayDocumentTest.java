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
class RejectStayDocumentTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @InjectMocks
    RejectStayDocumentUseCase rejectStayDocumentUseCase;

    @Test
    void rejectDocument() {
        UUID documentId = UUID.randomUUID();

        given(queryDocumentPort.queryDocumentByIdAndType(documentId, DocumentType.STAY)).willReturn(
                Document.builder()
                        .build()
        );

        // TODO 거절 비즈니스 로직 테스트 추가

        rejectStayDocumentUseCase.execute(documentId);
    }
}

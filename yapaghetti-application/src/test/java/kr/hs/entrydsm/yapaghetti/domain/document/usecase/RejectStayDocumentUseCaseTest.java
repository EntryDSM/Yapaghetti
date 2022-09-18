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
class RejectStayDocumentUseCaseTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @InjectMocks
    RejectStayDocumentUseCase rejectStayDocumentUseCase;

    @Test
    void rejectDocument() {
        UUID studentId = UUID.randomUUID();

        given(queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY)).willReturn(
                Document.builder()
                        .build()
        );

        rejectStayDocumentUseCase.execute(studentId);
    }
}

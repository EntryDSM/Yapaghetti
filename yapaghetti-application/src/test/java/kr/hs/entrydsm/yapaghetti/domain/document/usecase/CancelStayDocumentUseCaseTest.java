package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CancelStayDocumentUseCaseTest {

    @Mock
    CommandDocumentPort commandDocumentPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @InjectMocks
    CancelStayDocumentUseCase cancelStayDocumentUseCase;

    @Test
    void cancelStayDocument() {
        UUID documentId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        given(queryDocumentPort.queryDocumentByUserIdAndType(
                userId,
                DocumentType.STAY)
        ).willReturn(
                Document.builder()
                        .id(documentId)
                        .userId(userId)
                        .type(DocumentType.STAY)
                        .build()
        );

        cancelStayDocumentUseCase.execute(userId);
    }

}
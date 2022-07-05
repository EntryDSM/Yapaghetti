package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryStayDocumentTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

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

        queryStayDocumentUseCase.execute(documentId);
    }
}

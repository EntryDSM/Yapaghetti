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
class QueryPublicDocumentTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @InjectMocks
    QueryPublicDocumentUseCase queryPublicDocumentUseCase;

    @Test
    void queryPublicDocument() {
        UUID documentId = UUID.randomUUID();
        String content = "testContent";

        given(queryDocumentPort.queryDocumentByIdAndType(documentId, DocumentType.PUBLIC)).willReturn(
                Document.builder()
                        .content(content)
                        .build()
        );

        queryPublicDocumentUseCase.execute(documentId);
    }
}

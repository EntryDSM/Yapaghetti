package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateStayDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateStayDocumentTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @Mock
    DomainUpdateStayDocumentRequest request;

    @InjectMocks
    UpdateStayDocumentUseCase updateStayDocumentUseCase;

    @Test
    void updateDocument() {
        UUID currentUserId = UUID.randomUUID();

        given(request.getPreviewImagePath()).willReturn("testPreviewImagePath");
        given(request.getContent()).willReturn("testContent");
        given(documentSecurityPort.getCurrentUserId()).willReturn(currentUserId);
        given(queryDocumentPort.queryDocumentByUserIdAndType(currentUserId, DocumentType.STAY))
                .willReturn(Document.builder().build());

        updateStayDocumentUseCase.execute(request);
    }
}

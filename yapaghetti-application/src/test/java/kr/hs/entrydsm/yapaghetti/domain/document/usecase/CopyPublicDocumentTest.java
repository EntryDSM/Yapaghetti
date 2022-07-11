package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

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
class CopyPublicDocumentTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @InjectMocks
    CopyPublicDocumentUseCase copyPublicDocumentUseCase;

    @Test
    void copy() {
        UUID userId = UUID.randomUUID();

        given(documentSecurityPort.getCurrentUserId()).willReturn(userId);
        given(queryDocumentPort.queryDocumentByUserIdAndType(userId, DocumentType.PUBLIC)).willReturn(
                Document.builder()
                        .previewImagePath("testPreviewImage")
                        .content("testContent")
                        .type(DocumentType.PUBLIC)
                        .userId(userId)
                        .isRejected(false)
                        .build()
        );

        copyPublicDocumentUseCase.execute();
    }

}

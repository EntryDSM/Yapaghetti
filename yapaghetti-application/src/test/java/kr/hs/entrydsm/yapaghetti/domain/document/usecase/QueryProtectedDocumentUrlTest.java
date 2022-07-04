package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class QueryProtectedDocumentUrlTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @InjectMocks
    QueryProtectedDocumentUrlUseCase queryProtectedDocumentUrlUseCase;

    @Test
    void getUrl() {
        UUID userId = UUID.randomUUID();
        UUID documentId = UUID.randomUUID();

        given(userSecurityPort.getCurrentUserId()).willReturn(userId);
        given(queryDocumentPort.queryDocumentByUserIdAndType(userId, DocumentType.PROTECTED)).willReturn(
                Document.builder()
                        .id(documentId)
                        .build()
        );

        queryProtectedDocumentUrlUseCase.execute();
    }
}

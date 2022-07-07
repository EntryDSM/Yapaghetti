package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
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
class QueryLocalDocumentUseCaseTest {

    @Mock
    DocumentQueryUserPort documentQueryUserPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @InjectMocks
    QueryLocalDocumentUseCase queryLocalDocumentUseCase;

    @Test
    void queryLocalDocument() {
        UUID userId = UUID.randomUUID();
        UUID documentId = UUID.randomUUID();
        String LocalDocumentContent = "LocalDocumentContent";

        given(documentSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId()))
                .willReturn(User.builder()
                        .id(userId)
                        .build());
        given(queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                userId,
                documentId,
                DocumentType.LOCAL))
                .willReturn(
                        Document.builder()
                                .id(userId)
                                .content(LocalDocumentContent)
                                .build());

        queryLocalDocumentUseCase.execute(documentId);
    }

}
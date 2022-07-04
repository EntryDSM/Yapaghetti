package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
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
    QueryUserPort queryUserPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @InjectMocks
    QueryLocalDocumentUseCase queryLocalDocumentUseCase;

    @Test
    void queryLocalDocument() {
        UUID userId = UUID.randomUUID();
        UUID documentId = UUID.randomUUID();
        String LocalDocumentContent = "LocalDocumentContent";

        given(userSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryUserPort.queryUserById(userSecurityPort.getCurrentUserId()))
                .willReturn(User.builder()
                        .id(userId)
                        .build());
        given(queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                userId,
                documentId,
                DocumentType.LOCAL))
                .willReturn(Document.builder()
                        .id(userId)
                        .content(LocalDocumentContent)
                        .build());

        queryLocalDocumentUseCase.execute(documentId);
    }

}
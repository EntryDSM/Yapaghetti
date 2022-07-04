package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
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
class DeleteLocalDocumentUseCaseTest {

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @InjectMocks
    DeleteLocalDocumentUseCase deleteLocalDocumentUseCase;

    @Test
    void deleteLocalDocument() {
        UUID documentId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        given(userSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryUserPort.queryUserById(userSecurityPort.getCurrentUserId()))
                .willReturn(User.builder()
                        .id(userId)
                        .build());
        given(queryDocumentPort.queryDocumentByIdAndUserIdAndType(
                documentId,
                userId,
                DocumentType.LOCAL))
                .willReturn(Document.builder().build());

        deleteLocalDocumentUseCase.execute(documentId);
    }

}
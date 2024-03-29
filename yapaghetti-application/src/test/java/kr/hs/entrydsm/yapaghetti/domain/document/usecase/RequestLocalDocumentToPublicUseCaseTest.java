package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
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
class RequestLocalDocumentToPublicUseCaseTest {

    @Mock
    DocumentQueryUserPort documentQueryUserPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @Mock
    SendMailPort sendMailPort;

    @InjectMocks
    RequestLocalDocumentToPublicUseCase requestLocalDocumentToPublicUseCase;

    @Test
    void requestLocalDocumentToPublic() {
        UUID userId = UUID.randomUUID();
        UUID documentId = UUID.randomUUID();
        String email = "test@dsm.hs.kr";
        String name = "name";

        given(documentSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId()))
                .willReturn(
                        User.builder()
                                .id(userId)
                                .name(name)
                                .build()
                );
        given(queryDocumentPort
                .queryDocumentByIdAndUserIdAndType(documentId, userId, DocumentType.LOCAL))
                .willReturn(
                        Document.builder()
                                .id(documentId)
                                .build()
                );
        given(documentQueryUserPort.getTeacherEmail())
                .willReturn(email);

        requestLocalDocumentToPublicUseCase.execute(documentId);
    }
}
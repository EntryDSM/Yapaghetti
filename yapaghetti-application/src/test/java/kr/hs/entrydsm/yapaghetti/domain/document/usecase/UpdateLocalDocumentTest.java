package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
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
public class UpdateLocalDocumentTest {

    @Mock
    QueryUserPort queryUserPort;

    @Mock
    UserSecurityPort userSecurityPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandDocumentPort commandDocumentPort;

    @InjectMocks
    UpdateLocalDocumentUseCase updateLocalDocumentUseCase;

    @Mock
    DomainUpdateLocalDocumentRequest request;

    @Test
    void updateLocalDocument() {
        UUID documentId = UUID.randomUUID();
        String previewImagePath = "updatePreviewImagePath";
        String content = "updateContent";
        UUID userId = UUID.randomUUID();

        given(request.getDocumentId())
                .willReturn(documentId);
        given(request.getPreviewImagePath())
                .willReturn(previewImagePath);
        given(request.getContent())
                .willReturn(content);
        given(userSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(queryUserPort.queryUserById(userSecurityPort.getCurrentUserId()))
                .willReturn(User.builder()
                        .id(userId)
                        .build());
        given(queryDocumentPort
                .queryDocumentByIdAndUserIdAndType(documentId, userId, DocumentType.LOCAL))
                .willReturn(Document.builder()
                        .id(documentId)
                        .build());

        updateLocalDocumentUseCase.execute(request);
    }
}

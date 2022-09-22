package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateLocalDocumentUseCaseTest {

    @Mock
    CommandDocumentPort commandDocumentPort;

    @Mock
    DocumentQueryUserPort documentQueryUserPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @Mock
    DomainCreateDocumentRequest domainCreateDocumentRequest;

    @InjectMocks
    CreateLocalDocumentUseCase createLocalDocumentUseCase;

    @Test
    void createLocalDocument() {
        UUID userId = UUID.randomUUID();
        String content = "testContent";
        String previewImagePath = "testPreviewImagePath";

        given(domainCreateDocumentRequest.getContent())
                .willReturn(content);

        given(domainCreateDocumentRequest.getPreviewImagePath())
                .willReturn(previewImagePath);

        given(documentSecurityPort.getCurrentUserId())
                .willReturn(userId);

        given(documentQueryUserPort.queryUserById(any()))
                .willReturn(User.builder().build());

        createLocalDocumentUseCase.execute(domainCreateDocumentRequest);
    }
}

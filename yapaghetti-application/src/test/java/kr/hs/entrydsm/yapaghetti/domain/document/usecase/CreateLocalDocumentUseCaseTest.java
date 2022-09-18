package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

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

    @InjectMocks
    CreateLocalDocumentUseCase createLocalDocumentUseCase;

    @Test
    void createLocalDocument() {
        given(documentSecurityPort.getCurrentUserId())
                .willReturn(UUID.randomUUID());
        given(documentQueryUserPort.queryUserById(any()))
                .willReturn(User.builder().build());

        createLocalDocumentUseCase.execute();
    }
}

package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryLocalDocumentListUseCaseTest {

    @Mock
    DocumentQueryUserPort documentQueryUserPort;

    @Mock
    DocumentSecurityPort documentSecurityPort;

    @Mock
    DocumentQueryStudentPort documentQueryStudentPort;

    @Mock
    QueryDocumentPort queryDocumentPort;

    @InjectMocks
    QueryLocalDocumentListUseCase queryLocalDocumentListUseCase;

    @Test
    void queryLocalDocumentList() {
        UUID userId = UUID.randomUUID();
        String userName = "testUserName";
        UUID tagId = UUID.randomUUID();
        String tagName = "testTagName";
        String profileImagePath = "testProfileImagePath";
        String content = "testContent";

        given(documentSecurityPort.getCurrentUserId())
                .willReturn(userId);
        given(documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId()))
                .willReturn(
                        User.builder()
                                .id(userId)
                                .name(userName)
                                .build()
                );
        given(documentQueryStudentPort.queryTagByStudentId(userId))
                .willReturn(
                        Tag.builder()
                                .id(tagId)
                                .name(tagName)
                                .build()
                );
        given(queryDocumentPort.queryDocumentAllByUserIdAndType(userId, DocumentType.LOCAL))
                .willReturn(
                        List.of(
                                Document.builder()
                                        .id(UUID.randomUUID())
                                        .previewImagePath(profileImagePath)
                                        .build(),
                                Document.builder()
                                        .id(UUID.randomUUID())
                                        .previewImagePath(profileImagePath)
                                        .build()
                        )
                );

        queryLocalDocumentListUseCase.execute();
    }

}
package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.CreateLocalDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateLocalDocumentUseCase implements CreateLocalDocumentPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final CommandDocumentPort commandDocumentPort;

    @Override
    public CreateLocalDocumentResponse execute() {
        User user = documentQueryUserPort.queryUserById(documentSecurityPort.getCurrentUserId());

        UUID documentId = commandDocumentPort.saveDocumentAndGetId(
                Document.builder()
                        // TODO previewImagePath랑 content값은 더미 값임.
                        .previewImagePath("https://s3.ap-northeast-2.amazonaws.com/image.entrydsm.hs.kr/repo/profile/eaa93c77-99b8-45e2-ae09-eec58cecf8fa.png")
                        .content("{args: {\n" +
                                "            name: '이름',\n" +
                                "            email: '이메일',\n" +
                                "            phone: '전화번호',\n" +
                                "            github: 'https://github.com',\n" +
                                "            imageUrl: '',\n" +
                                "            feedback: { isRead: false, feedInfo: '' },\n" +
                                "        },\n" +
                                "id: \"2baa202b-dda7-4ade-b050-08ced8e9e976\"\n" +
                                "}")
                        .type(DocumentType.LOCAL)
                        .userId(user.getId())
                        .isRejected(false)
                        .build()
        );

        return new CreateLocalDocumentResponse(documentId);
    }
}

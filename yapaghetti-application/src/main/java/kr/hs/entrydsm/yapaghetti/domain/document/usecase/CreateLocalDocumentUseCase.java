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
                        .content("[{\n" +
                                "id:\"7a930fa0-a818-40d1-9945-efc50ccd722e\",\n" +
                                "args:\"{\"tagType\":\"Profile\",\"github\":\"https://github.com/\",\"name\":\"12314124\",\"email\":\"default@gmail.com\",\"phone\":\"010-0000-0000\",\"imageUrl\":\"\",\"feedback\":{\"isRead\":false,\"feedInfo\":\"\"},\"isTeacher\":false}]")
                        .type(DocumentType.LOCAL)
                        .userId(user.getId())
                        .isRejected(false)
                        .build()
        );

        return new CreateLocalDocumentResponse(documentId);
    }
}

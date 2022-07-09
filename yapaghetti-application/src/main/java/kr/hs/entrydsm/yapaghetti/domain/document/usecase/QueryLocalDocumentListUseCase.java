package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryLocalDocumentListPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.DocumentElement;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryLocalDocumentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class QueryLocalDocumentListUseCase implements QueryLocalDocumentListPort {

    private final DocumentQueryUserPort documentQueryUserPort;
    private final DocumentSecurityPort documentSecurityPort;
    private final DocumentQueryTagPort documentQueryTagPort;
    private final QueryDocumentPort queryDocumentPort;

    @Override
    public QueryLocalDocumentListResponse execute() {
        UUID currentUserId = documentSecurityPort.getCurrentUserId();
        User user = documentQueryUserPort.queryUserById(currentUserId);


        Tag majorTag = documentQueryTagPort.queryMajorTagByStudentId(currentUserId);

        List<DocumentElement> localDocumentList =
                queryDocumentPort.queryDocumentAllByUserIdAndType(currentUserId, DocumentType.LOCAL)
                        .stream()
                        .map(document -> DocumentElement.builder()
                                .documentId(document.getId())
                                .previewImagePath(document.getPreviewImagePath())
                                .name(user.getName())
                                .major(majorTag.getName())
                                .build())
                        .collect(Collectors.toList());

        return new QueryLocalDocumentListResponse(localDocumentList);
    }
}

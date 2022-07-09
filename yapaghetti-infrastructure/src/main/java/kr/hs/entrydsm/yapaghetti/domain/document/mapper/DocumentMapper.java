package kr.hs.entrydsm.yapaghetti.domain.document.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DocumentMapper {

    private final UserPersistenceAdapter userPersistenceAdapter;

    public Document entityToDomain(DocumentEntity documentEntity) {
        return Document.builder()
                .id(documentEntity.getId())
                .previewImagePath(documentEntity.getPreviewImagePath())
                .content(documentEntity.getContent())
                .type(documentEntity.getType())
                .userId(documentEntity.getUserId())
                .isRejected(documentEntity.getIsRejected())
                .build();
    }

    public DocumentEntity domainToEntity(Document document) {
        UserEntity userEntity = userPersistenceAdapter.findUserById(document.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return DocumentEntity.builder()
                .previewImagePath(document.getPreviewImagePath())
                .content(document.getContent())
                .type(document.getType())
                .userEntity(userEntity)
                .isRejected(document.getIsRejected())
                .build();
    }
}

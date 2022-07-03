package kr.hs.entrydsm.yapaghetti.domain.document.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserRepository;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DocumentMapper {

    private final UserRepository userRepository;

    public Document entityToDomain(DocumentEntity documentEntity) {
        return Document.builder()
                .id(documentEntity.getId())
                .previewImagePath(documentEntity.getPreviewImagePath())
                .content(documentEntity.getContent())
                .type(documentEntity.getType())
                .publicId(documentEntity.getPublicId())
                .user(documentEntity.getUserId())
                .build();
    }

    public DocumentEntity domainToEntity(Document document) {
        UserEntity userEntity = userRepository.findById(document.getUser())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return DocumentEntity.builder()
                .previewImagePath(document.getPreviewImagePath())
                .content(document.getContent())
                .type(document.getType())
                .user(userEntity)
                .build();
    }
}

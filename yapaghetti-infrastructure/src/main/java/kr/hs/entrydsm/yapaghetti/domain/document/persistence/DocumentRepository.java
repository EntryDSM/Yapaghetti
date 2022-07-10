package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
    Optional<DocumentEntity> findByUserEntityIdAndType(UUID userId, DocumentType type);

    Optional<DocumentEntity> findByIdAndType(UUID documentId, DocumentType type);

    Optional<DocumentEntity> findByIdAndUserEntityIdAndType(UUID id, UUID userId, DocumentType type);

    List<DocumentEntity> findAllByUserEntityIdAndType(UUID userId, DocumentType type);

    List<DocumentEntity> findAllByUserEntityIdAndTypeNotIn(UUID userId, List<DocumentType> type);
}

package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface DocumentRepository extends CrudRepository<DocumentEntity, UUID> {
    Optional<DocumentEntity> findByUserEntityIdAndType(UUID userId, DocumentType type);

    Optional<DocumentEntity> findByIdAndUserEntityIdAndType(UUID id, UUID userId, DocumentType type);
}

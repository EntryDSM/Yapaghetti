package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentEntity, UUID> {
}

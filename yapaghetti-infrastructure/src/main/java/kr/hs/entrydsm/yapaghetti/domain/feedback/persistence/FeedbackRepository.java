package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntityId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedbackRepository extends CrudRepository<FeedbackEntity, FeedbackEntityId> {
    Optional<FeedbackEntity> findByIdDocumentIdAndIdSequence(UUID id_documentId, Integer id_sequence);

    List<FeedbackEntity> findByIdDocumentId(UUID id_documentId);

    void deleteAllByIdDocumentId(UUID documentId);
}

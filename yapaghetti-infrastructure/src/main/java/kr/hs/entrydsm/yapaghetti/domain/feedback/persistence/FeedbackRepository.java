package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedbackRepository extends CrudRepository<FeedBackEntity, FeedBackEntityId> {
    Optional<FeedBackEntity> findByIdDocumentIdAndIdSequence(UUID id_documentId, Integer id_sequence);
	List<FeedBackEntity> findByIdDocumentId(UUID id_documentId);
}

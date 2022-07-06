package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import java.util.Optional;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<FeedBackEntity, FeedBackEntityId> {
	Optional<FeedBackEntity> findByIdDocumentIdAndIdSequence(UUID id_documentId,
		Integer id_sequence);
}

package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import org.springframework.data.repository.CrudRepository;

public interface FeedBackRepository extends CrudRepository<FeedBackEntity, FeedBackEntityId> {
}

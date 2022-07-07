package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackMapper {

	public FeedBackEntity domainToEntity(Feedback feedback) {
		return FeedBackEntity.builder()
			.id(
				new FeedBackEntityId(
					feedback.getSequence(),
					feedback.getDocumentId()
				)
			)
			.comment(feedback.getComment())
			.isApply(feedback.getIsApply())
			.build();
	}

	public Feedback entityToDomain(FeedBackEntity feedBackEntity) {
		return Feedback.builder()
			.sequence(feedBackEntity.getId().getSequence())
			.documentId(feedBackEntity.getDocumentId())
			.comment(feedBackEntity.getComment())
			.isApply(feedBackEntity.getIsApply())
			.build();
	}
}

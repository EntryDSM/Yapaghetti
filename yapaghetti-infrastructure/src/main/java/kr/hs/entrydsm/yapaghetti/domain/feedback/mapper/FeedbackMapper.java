package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackMapper {

	public FeedbackEntity domainToEntity(Feedback feedback) {
		return FeedbackEntity.builder()
			.id(
				new FeedbackEntityId(
					feedback.getSequence(),
					feedback.getDocumentId()
				)
			)
			.comment(feedback.getComment())
			.isApply(feedback.getIsApply())
			.build();
	}

	public Feedback entityToDomain(FeedbackEntity feedBackEntity) {
		return Feedback.builder()
			.sequence(feedBackEntity.getId().getSequence())
			.documentId(feedBackEntity.getDocumentId())
			.comment(feedBackEntity.getComment())
			.isApply(feedBackEntity.getIsApply())
			.build();
	}
}

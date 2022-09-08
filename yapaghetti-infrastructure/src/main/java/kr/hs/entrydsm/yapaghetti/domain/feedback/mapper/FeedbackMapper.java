package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.DocumentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackMapper {

	private final DocumentPersistenceAdapter documentPersistenceAdapter;
	private final DocumentMapper documentMapper;

	public FeedbackEntity domainToEntity(Feedback feedback) {
		return FeedbackEntity.builder()
			.id(
				new FeedbackEntityId(
					feedback.getSequence(),
					feedback.getDocumentId()
				)
			)
			.documentEntity(
					documentMapper.domainToEntity(
							documentPersistenceAdapter.queryDocumentByIdAndType(
									feedback.getDocumentId(), DocumentType.STAY
							)
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

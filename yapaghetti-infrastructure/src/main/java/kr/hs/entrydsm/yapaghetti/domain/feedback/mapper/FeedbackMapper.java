package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.exception.DocumentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.DocumentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.DocumentRepository;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedbackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackMapper {

	private final DocumentRepository documentRepository;

	public FeedbackEntity domainToEntity(Feedback feedback) {

		DocumentEntity documentEntity = documentRepository.findById(feedback.getDocumentId())
			.orElseThrow(() -> DocumentNotFoundException.EXCEPTION);

		return FeedbackEntity.builder()
			.id(
				new FeedbackEntityId(
					feedback.getSequence(),
					feedback.getDocumentId()
				)
			)
			.documentEntity(documentEntity)
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

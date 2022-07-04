package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.persistence.DocumentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedbackMapper {

    private final DocumentPersistenceAdapter documentPersistenceAdapter;

    public FeedBackEntity domainToEntity(FeedBack feedBack) {
        return FeedBackEntity.builder()
                .id(
                    FeedBackEntityId.builder()
                                .documentId(feedBack.getDocumentId())
                                .sequence(feedBack.getSequence())
                            .build()
                )
                .document(
                        documentPersistenceAdapter.queryDocumentEntityById(
                                feedBack.getDocumentId()
                        )
                )
                .comment(feedBack.getContent())
                .isApply(feedBack.isApply())
                .build();

    }

}

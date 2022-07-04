package kr.hs.entrydsm.yapaghetti.domain.feedback.mapper;

import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.DocumentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntity;
import kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.FeedBackEntityId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedBackMapper {

    private final DocumentPersistenceAdapter documentPersistenceAdapter;

    private final DocumentMapper documentMapper;

    public FeedBackEntity domainToEntity(FeedBack feedBack) {
        DocumentEntity documentEntity = documentMapper.domainToEntity(
                documentPersistenceAdapter.queryDocumentById(feedBack.getDocumentId())
        );

        return FeedBackEntity.builder()
                .id(
                        FeedBackEntityId.builder()
                                .documentId(feedBack.getDocumentId())
                                .sequence(feedBack.getSequence())
                                .build()
                )
                .isApply(feedBack.isApply())
                .comment(feedBack.getComment())
                .document(
                        documentEntity
                )
                .build();
    }

}

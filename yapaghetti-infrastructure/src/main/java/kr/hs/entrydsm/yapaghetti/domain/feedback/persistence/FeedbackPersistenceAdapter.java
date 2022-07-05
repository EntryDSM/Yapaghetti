package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.exception.FeedbackNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.feedback.mapper.FeedbackMapper;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.QueryFeedbackPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeedbackPersistenceAdapter implements QueryFeedbackPort, CommandFeedbackPort {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Override
    public Feedback queryFeedbackByDocumentIdAndSequence(UUID documentId, Integer sequence) {
        return feedbackMapper.entityToDomain(
            feedbackRepository.findByIdDocumentIdAndIdSequence(documentId, sequence)
                .orElseThrow(() -> FeedbackNotFoundException.EXCEPTION)
        );
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        feedbackRepository.save(
            feedbackMapper.domainToEntity(feedback)
        );
    }
}

package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.exception.FeedbackNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.feedback.mapper.FeedbackMapper;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.FeedbackPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class FeedbackPersistenceAdapter implements FeedbackPort {

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
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(
                feedbackMapper.domainToEntity(feedback)
        );
    }

    @Override
    public List<Feedback> queryFeedbackByDocumentId(UUID documentId) {
        return feedbackRepository.findByIdDocumentId(documentId)
                .stream()
                .map(feedbackMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}

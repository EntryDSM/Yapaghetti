package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.mapper.FeedbackMapper;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeedBackPersistenceAdapter implements CommandFeedbackPort {

    private final FeedBackRepository feedBackRepository;

    private final FeedbackMapper feedbackMapper;

    @Override
    public void saveFeedback(FeedBack feedBack) {
        feedBackRepository.save(
                feedbackMapper.domainToEntity(feedBack)
        );
    }
}

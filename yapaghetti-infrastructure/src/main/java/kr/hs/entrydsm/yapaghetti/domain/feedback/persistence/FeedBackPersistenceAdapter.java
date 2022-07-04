package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;
import kr.hs.entrydsm.yapaghetti.domain.feedback.mapper.FeedBackMapper;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedBackPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeedBackPersistenceAdapter implements CommandFeedBackPort {

    private final FeedBackRepository feedBackRepository;

    private final FeedBackMapper feedBackMapper;

    @Override
    public void saveFeedBack(FeedBack feedBack) {
        feedBackRepository.save(
                feedBackMapper.domainToEntity(feedBack)
        );
    }
}

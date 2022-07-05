package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.FeedBack;

public interface CommandFeedBackPort {
    void saveFeedBack(FeedBack feedBack);
}

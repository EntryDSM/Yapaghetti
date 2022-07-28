package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

public interface CommandFeedbackPort {
    void saveFeedback(Feedback feedback);
}

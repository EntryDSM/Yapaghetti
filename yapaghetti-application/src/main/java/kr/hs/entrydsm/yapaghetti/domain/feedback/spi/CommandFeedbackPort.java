package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentCommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

public interface CommandFeedbackPort extends DocumentCommandFeedbackPort {
    void saveFeedback(Feedback feedback);
}

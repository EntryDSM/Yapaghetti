package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentCommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandFeedbackPort;

public interface CommandFeedbackPort extends DocumentCommandFeedbackPort, TeacherCommandFeedbackPort {
    void saveFeedback(Feedback feedback);
}

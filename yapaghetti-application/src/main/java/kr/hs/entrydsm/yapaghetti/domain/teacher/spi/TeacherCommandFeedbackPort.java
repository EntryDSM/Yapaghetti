package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

public interface TeacherCommandFeedbackPort {

    void saveFeedback(Feedback feedback);

}

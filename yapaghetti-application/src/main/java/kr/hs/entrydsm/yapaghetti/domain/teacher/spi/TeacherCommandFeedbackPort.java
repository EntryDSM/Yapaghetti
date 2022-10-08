package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

import java.util.UUID;

public interface TeacherCommandFeedbackPort {

    void saveFeedback(Feedback feedback);

    void deleteFeedbackByDocumentIdAndSequence(UUID documentId, Integer sequence);

}

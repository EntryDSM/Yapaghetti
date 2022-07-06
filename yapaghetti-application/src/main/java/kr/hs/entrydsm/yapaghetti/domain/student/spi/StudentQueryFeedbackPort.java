package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

import java.util.UUID;

public interface StudentQueryFeedbackPort {
    Feedback queryFeedbackByDocumentIdAndSequence(UUID documentId, Integer sequence);
}

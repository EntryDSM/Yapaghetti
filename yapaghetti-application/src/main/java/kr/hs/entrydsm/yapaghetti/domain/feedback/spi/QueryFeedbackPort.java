package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

public interface QueryFeedbackPort {
	Feedback queryFeedbackByDocumentIdAndSequence(UUID documentId, Integer sequence);
}

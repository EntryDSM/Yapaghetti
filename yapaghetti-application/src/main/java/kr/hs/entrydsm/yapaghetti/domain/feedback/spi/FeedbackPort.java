package kr.hs.entrydsm.yapaghetti.domain.feedback.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryFeedbackPort;

public interface FeedbackPort extends CommandFeedbackPort, StudentQueryFeedbackPort, DocumentQueryFeedbackPort {
}

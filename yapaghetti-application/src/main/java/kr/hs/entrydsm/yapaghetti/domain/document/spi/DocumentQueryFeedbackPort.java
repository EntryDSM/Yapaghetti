package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;

import java.util.List;
import java.util.UUID;

public interface DocumentQueryFeedbackPort {
    List<Feedback> queryFeedbackByDocumentId(UUID documentId);
}

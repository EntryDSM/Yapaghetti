package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class QueryStayDocumentResponse {

    private final List<FeedbackElement> feedbackList;

    private final String content;

    private final UUID documentId;

}

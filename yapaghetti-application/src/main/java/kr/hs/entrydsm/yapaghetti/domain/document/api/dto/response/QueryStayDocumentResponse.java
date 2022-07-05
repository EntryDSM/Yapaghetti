package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryStayDocumentResponse {

    private final List<QueryFeedBackResponse> feedBackList;

    private final String content;

}

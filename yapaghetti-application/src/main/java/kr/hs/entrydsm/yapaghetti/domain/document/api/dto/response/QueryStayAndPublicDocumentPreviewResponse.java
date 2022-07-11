package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryStayAndPublicDocumentPreviewResponse {

    private final List<StayAndPublicDocumentElement> documentList;
}

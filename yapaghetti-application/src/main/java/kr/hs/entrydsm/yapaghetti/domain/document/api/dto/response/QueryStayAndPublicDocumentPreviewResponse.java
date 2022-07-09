package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryStayAndPublicDocumentPreviewResponse {

    private final String stayPreviewImagePath;
    private final String publicPreviewImagePath;
}

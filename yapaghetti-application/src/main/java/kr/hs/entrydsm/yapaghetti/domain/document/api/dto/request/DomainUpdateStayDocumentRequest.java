package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainUpdateStayDocumentRequest {
    private final String previewImagePath;
    private final String content;
}

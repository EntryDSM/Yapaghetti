package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainCreateDocumentRequest {
    private final String content;
    private final String previewImagePath;
}

package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainCreateLocalDocumentRequest {

    private final String previewImagePath;
    private final String content;
}

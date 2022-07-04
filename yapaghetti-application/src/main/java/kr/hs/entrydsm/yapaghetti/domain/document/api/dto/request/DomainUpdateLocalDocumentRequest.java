package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class DomainUpdateLocalDocumentRequest {

    private final UUID documentId;
    private final String previewImagePath;
    private final String content;
}

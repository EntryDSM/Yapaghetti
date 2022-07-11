package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StayAndPublicDocumentElement {

    private final DocumentType type;
    private final String previewImagePath;
}

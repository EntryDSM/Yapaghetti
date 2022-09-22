package kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebCreateLocalDocumentRequest {
    private String content;
    private String previewImagePath;
}

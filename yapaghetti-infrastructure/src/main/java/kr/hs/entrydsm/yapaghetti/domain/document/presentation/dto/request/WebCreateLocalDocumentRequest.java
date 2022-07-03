package kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebCreateLocalDocumentRequest {

    @NotBlank
    private String previewImagePath;

    @NotBlank
    private String content;
}

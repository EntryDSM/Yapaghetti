package kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebCreateLocalDocumentRequest {

    @Max(255)
    @NotBlank
    private String previewImagePath;

    @Max(65535)
    @NotBlank
    private String content;
}

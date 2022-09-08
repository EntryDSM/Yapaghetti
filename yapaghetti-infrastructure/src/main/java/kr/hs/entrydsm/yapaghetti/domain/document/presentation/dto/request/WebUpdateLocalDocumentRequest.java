package kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebUpdateLocalDocumentRequest {

    @Size(max = 255)
    @NotBlank
    private String previewImagePath;

    @Size(max = 65535)
    @NotBlank
    private String content;
}

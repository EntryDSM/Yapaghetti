package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebAddTagRequest {

    @Size(max = 20)
    @NotBlank
    private String name;

    @NotNull
    private Boolean isMajor;

}

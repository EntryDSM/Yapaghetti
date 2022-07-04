package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class WebAddTagRequest {

    @Max(20)
    @NotBlank
    private String name;

    @NotNull
    private Boolean isMajor;

}

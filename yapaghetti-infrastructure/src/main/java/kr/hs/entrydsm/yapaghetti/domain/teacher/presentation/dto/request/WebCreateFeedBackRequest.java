package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class WebCreateFeedBackRequest {

    @NotNull
    private Integer sequence;

    @NotBlank
    private String content;

}
